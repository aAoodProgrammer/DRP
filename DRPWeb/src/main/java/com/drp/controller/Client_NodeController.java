package com.drp.controller;

import com.drp.pojo.Client;
import com.drp.repository.ClientRepository;
import com.drp.service.IClientService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 刘江涛
 * @ClassName: Client_NodeController
 * @Description:
 * @date 2018/5/1 19:38
 */
@SessionAttributes( "client" )
@Controller
public class Client_NodeController {

    @Resource
    private IClientService iClientService;

    @Resource
    private ClientRepository clientRepository;

    @RequestMapping( value = "/getClient_nodeAll.action", method = RequestMethod.GET )
    @ResponseBody
    public String getClient_nodeAll() {
        List<Client> clientList = iClientService.findAll();
        //去掉外键
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter((sorce, name, value) -> name.equals("level") || name.equals("client") ||
                name.equals("clients") || name.equals("flowCardMains") || name.equals("inventories"));
        JSONArray jsonArray = JSONArray.fromObject(clientList, jsonConfig);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clientList", jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping( value = "/addClient_node.action", method = RequestMethod.POST )
    @ResponseBody
    public String addClient_node(Client client) {
        client.setId(null);
        client.setIsLeaf("是");
        iClientService.add(client);
        return "success";
    }

    @RequestMapping( value = "/getOneClient_node.action", method = RequestMethod.GET )
    @ResponseBody
    public String getOneClient_node(Integer id, Map<String, Object> map) {
        Client client = iClientService.findOne(id);
        map.put("client", client);
        return "success";
    }

    @RequestMapping( value = "/updateClient_node.action", method = RequestMethod.POST )
    @ResponseBody
    public String updateClient_node(Client client) {
        iClientService.update(client);
        return "success";
    }

    @RequestMapping( value = "/deleteClient_node.action", method = RequestMethod.POST )
    @ResponseBody
    public String deleteClient_node(String ids) {
        List<Integer> idsList = new ArrayList<>();
        //判断是否有“-”，没有就表示只删除一个
        ItemController.getIDList(ids, idsList);
        iClientService.deleteByIds(idsList);
        return "success";
    }

    /**
     * 根据物料id和名字查询
     *
     * @return
     */
    @GetMapping( "/findByClientCodeAndName.action" )
    @ResponseBody
    public String findByClientCodeAndName(String clientCodeOrName) {
        List<Client> clientList = iClientService.findAll();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = null;
        List<Client> clients = new ArrayList<>();
        //去掉外键
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter((source, name, value) -> name.equals("level") || name.equals("client") ||
                name.equals("clients") || name.equals("flowCardMains") || name.equals("inventories"));
        for (Client client : clientList) {
            String code = client.getCode();
            String name = client.getName();
            if (code.equals(clientCodeOrName) && !name.contains(clientCodeOrName)) {
                Client byCode = clientRepository.findByCode(clientCodeOrName);
                clients.add(byCode);
            } else if (!code.equals(clientCodeOrName) && name.contains(clientCodeOrName)) {
                Client byName = clientRepository.findAllByName(name);
                clients.add(byName);
            } else if (code.equals(clientCodeOrName) && name.contains(clientCodeOrName)) {
                Client byCode = clientRepository.findByCode(clientCodeOrName);
                clients.add(byCode);
            }
        }
        jsonArray = JSONArray.fromObject(clients, jsonConfig);
        jsonObject.put("clientList", jsonArray);
        return jsonObject.toString();
    }
}

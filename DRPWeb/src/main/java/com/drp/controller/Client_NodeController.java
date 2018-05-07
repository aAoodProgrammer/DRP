package com.drp.controller;

import com.drp.pojo.Client;
import com.drp.service.IClientService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

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
@SessionAttributes("client")
@Controller
public class Client_NodeController {

    @Resource
    private IClientService iClientService;

    @RequestMapping(value = "/getClient_nodeAll.action", method = RequestMethod.GET)
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

    @RequestMapping(value = "/addClient_node.action", method = RequestMethod.POST)
    @ResponseBody
    public String addClient_node(Client client) {
        client.setId(null);
        client.setIsLeaf("是");
        iClientService.add(client);
        return "success";
    }

    @RequestMapping(value = "/getOneClient_node.action", method = RequestMethod.GET)
    @ResponseBody
    public String getOneClient_node(Integer id, Map<String, Object> map) {
        Client client = iClientService.findOne(id);
        map.put("client", client);
        return "success";
    }

    @RequestMapping(value = "/updateClient_node.action", method = RequestMethod.POST)
    @ResponseBody
    public String updateClient_node(Client client) {
        iClientService.update(client);
        return "success";
    }

    @RequestMapping(value = "/deleteClient_node.action", method = RequestMethod.POST)
    @ResponseBody
    public String deleteClient_node(String ids) {
        List<Integer> idsList = new ArrayList<>();
        //判断是否有“-”，没有就表示只删除一个
        if (ids.contains("-")) {
            //用“-”截取loginids
            String[] idsStrings = ids.split("-");
            for (String idString : idsStrings) {
                idsList.add(Integer.parseInt(idString));
            }
        } else {
            idsList.add(Integer.parseInt(ids));
        }
        iClientService.deleteByIds(idsList);
        return "success";
    }
}

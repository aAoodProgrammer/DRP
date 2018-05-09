package com.drp.controller;

import java.util.ArrayList;
import java.util.List;

import com.drp.dto.InventoryDto;
import com.drp.pojo.Client;
import com.drp.pojo.Item;
import com.drp.repository.ClientRepository;
import com.drp.repository.InventoryRepository;
import com.drp.repository.ItemRepository;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.drp.pojo.Inventory;
import com.drp.service.IInventoryService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Resource
    private IInventoryService inventoryService;

    @Resource
    private InventoryRepository inventoryRepository;
    @Resource
    private ClientRepository clientRepository;
    @Resource
    private ItemRepository itemRepository;

    @RequestMapping("/findAll.action")
    @ResponseBody
    public String findAll() {
        List<Inventory> inventoryList = inventoryService.findAll();
        List<InventoryDto> inventoryDtoList = new ArrayList<>();
        for (Inventory inventory : inventoryList) {
            Integer id = inventory.getId();
            Integer clientId = inventory.getClientId();
            Client client = clientRepository.findById(clientId);
            Integer itemId = inventory.getItemId();
            Item item = itemRepository.findOne(itemId);
            inventoryDtoList.add(new InventoryDto(id, client.getCode(), client.getName(), item.getCode(), item.getName(), item.getSpecification(), item.getModelNum(), inventory.getIsVerify(), inventory.getInitialNum()));
        }
        JSONArray jsonArray = JSONArray.fromObject(inventoryDtoList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("inventoryDtoList", jsonArray);
        return jsonObject.toString();
    }
    
    @RequestMapping("/add.action")
    public String add(String clientCode, String itemCode, Integer initialNum) {
        Inventory inventory = new Inventory();
        Client client = clientRepository.findByCode(clientCode);
        Item item = itemRepository.findByCode(itemCode);
        inventory.setClientId(client.getId());
        inventory.setItemId(item.getId());
        inventory.setIsVerify("否");
        inventory.setInitialNum(initialNum);
        inventory.setInNum(0);
        inventory.setOutNum(0);
        inventoryService.add(inventory);
        return "inventory/inv_init_qty_maint";
    }

    @RequestMapping("/update.action")
    public String update(Integer id, String clientCode, String itemCode, Integer initialNum) {
        Inventory inventory = inventoryService.findOne(id);
        Client client = clientRepository.findByCode(clientCode);
        Item item = itemRepository.findByCode(itemCode);
        inventory.setInitialNum(initialNum);
        inventory.setClientId(client.getId());
        inventory.setItemId(item.getId());
        inventoryService.update(inventory);
        return "inventory/inv_init_qty_maint";
    }

    @RequestMapping("/deleteInventory.action")
    @ResponseBody
    public void delete(@RequestParam(value = "ids", required = false) String ids) {
        if (ids.contains("-")) {
            String[] idArray = ids.split("-");
            for (String id : idArray) {
                inventoryService.delete(Integer.parseInt(id));
            }
        } else {
            inventoryService.delete(Integer.parseInt(ids));
        }
    }

    @RequestMapping("/findOne.action")
    @ResponseBody
    public Integer findOne(@RequestParam("ids") String ids, HttpServletRequest request) {
        if (ids.length() == 0) {
            return 0;
        }
        if (ids.contains("-")) {
            return 1;
        }
        if (!ids.contains("-")) {
            HttpSession session = request.getSession();
            Inventory inventory = inventoryService.findOne(Integer.parseInt(ids));
            Client client = clientRepository.findOne(inventory.getClientId());
            Item item = itemRepository.findOne(inventory.getItemId());
            InventoryDto inventoryDto = new InventoryDto(inventory.getId(), client.getCode(), item.getCode(), inventory.getInitialNum());
            session.setAttribute("inventoryDto", inventoryDto);
            return 3;
        }
        return null;
    }

    @RequestMapping("/updateIsVerify.action")
    @ResponseBody
    public Integer updateIsVerify(@RequestParam("ids") String ids) {
        if (ids.length() == 0) {
            return 0;
        }
        if (ids.contains("-")) {
            return 1;
        }
        if (!ids.contains("-")) {
            Inventory inventory = inventoryService.findOne(Integer.parseInt(ids));
            if (inventory.getIsVerify().equals("是")) {
                return 2;
            } else {
                inventory.setIsVerify("是");
                inventoryService.update(inventory);
                return 3;
            }
        }
        return null;
    }

    @RequestMapping("/findByClientCodeOrItemCode.action")
    @ResponseBody
    public String findByClientCodeOrItemCode(String clientCode, String itemCode) {
        if (clientCode != null && !clientCode.equals("") && itemCode != null && !itemCode.equals("")) {
            Client client = clientRepository.findByCode(clientCode);
            Item item = itemRepository.findByCode(itemCode);
            List<Inventory> inventoryList = inventoryRepository.findAllByClientIdAndItemId(client.getId(), item.getId());
            List<InventoryDto> inventoryDtoList = new ArrayList<>();
            for (Inventory inventory : inventoryList) {
                Integer id = inventory.getId();
                inventoryDtoList.add(new InventoryDto(id, clientCode, client.getName(), itemCode, item.getName(), item.getSpecification(), item.getModelNum(), inventory.getIsVerify(), inventory.getInitialNum()));
            }
            JSONArray jsonArray = JSONArray.fromObject(inventoryDtoList);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("inventoryDtoList", jsonArray);
            return jsonObject.toString();
        } else if (clientCode == null || clientCode.equals("") && itemCode != null && !itemCode.equals("")) {
            Item item = itemRepository.findByCode(itemCode);
            List<Inventory> inventoryList = inventoryRepository.findAllByItemId(item.getId());
            List<InventoryDto> inventoryDtoList = new ArrayList<>();
            for (Inventory inventory : inventoryList) {
                Integer id = inventory.getId();
                Integer clientId = inventory.getClientId();
                Client client = clientRepository.findById(clientId);
                inventoryDtoList.add(new InventoryDto(id, client.getCode(), client.getName(), item.getCode(), item.getName(), item.getSpecification(), item.getModelNum(), inventory.getIsVerify(), inventory.getInitialNum()));
            }
            JSONArray jsonArray = JSONArray.fromObject(inventoryDtoList);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("inventoryDtoList", jsonArray);
            return jsonObject.toString();
        } else if (itemCode == null || itemCode.equals("") && clientCode != null && !clientCode.equals("")) {
            Client client = clientRepository.findByCode(clientCode);
            List<Inventory> inventoryList = inventoryRepository.findAllByClientId(client.getId());
            List<InventoryDto> inventoryDtoList = new ArrayList<>();
            for (Inventory inventory : inventoryList) {
                Integer id = inventory.getId();
                Integer itemId = inventory.getItemId();
                Item item = itemRepository.findOne(itemId);
                inventoryDtoList.add(new InventoryDto(id, client.getCode(), client.getName(), item.getCode(), item.getName(), item.getSpecification(), item.getModelNum(), inventory.getIsVerify(), inventory.getInitialNum()));
            }
            JSONArray jsonArray = JSONArray.fromObject(inventoryDtoList);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("inventoryDtoList", jsonArray);
            return jsonObject.toString();
        } else
            return null;
    }
}



package com.drp.controller;

import java.util.ArrayList;
import java.util.List;

import com.drp.dto.InventoryDto;
import com.drp.pojo.Client;
import com.drp.pojo.Item;
import com.drp.repository.ClientRepository;
import com.drp.repository.ItemRepository;
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
    private ClientRepository clientRepository;
    @Resource
    private ItemRepository itemRepository;

    /**
     * 查询所有
     */
    @RequestMapping("/inv_init_qty_maint.action")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Inventory> inventories = inventoryService.findAll();
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        for (Inventory inventory : inventories) {
            Integer clientId = inventory.getClientId();
            Client client = clientRepository.findOne(clientId);
            Integer itemId = inventory.getItemId();
            Item item = itemRepository.findOne(itemId);
            inventoryDtos.add(new InventoryDto(inventory.getId(), clientId, itemId, client.getCode(), client.getName(), item.getCode(),
                    item.getName(), item.getSpecification(), item.getModelNum(), inventory.getIsVerify(), inventory.getInitialNum()));
        }
        modelAndView.addObject("inventoryDtos", inventoryDtos);
        modelAndView.setViewName("inventory/inv_init_qty_maint");
        return modelAndView;
    }

    @RequestMapping("/inv_init_qty_confirm.action")
    public ModelAndView findAll1() {
        ModelAndView modelAndView = new ModelAndView();
        List<Inventory> inventories = inventoryService.findAll();
        List<InventoryDto> inventoryDtoList = new ArrayList<>();
        for (Inventory inventory : inventories) {
            Integer clientId = inventory.getClientId();
            Client client = clientRepository.findOne(clientId);
            Integer itemId = inventory.getItemId();
            Item item = itemRepository.findOne(itemId);
            inventoryDtoList.add(new InventoryDto(inventory.getId(), clientId, itemId, client.getCode(), client.getName(), item.getCode(),
                    item.getName(), item.getSpecification(), item.getModelNum(), inventory.getIsVerify(), inventory.getInitialNum()));
        }
        modelAndView.addObject("inventoryDtoList", inventoryDtoList);
        modelAndView.setViewName("inventory/inv_init_qty_confirm");
        return modelAndView;
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
}



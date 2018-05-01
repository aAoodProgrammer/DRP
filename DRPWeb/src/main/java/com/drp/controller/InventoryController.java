package com.drp.controller;

import java.util.List;

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

    /**
     * 查询所有
     */
    @RequestMapping("/inv_init_qty_maint.action")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Inventory> inventories = inventoryService.findAll();
        modelAndView.addObject("inventories", inventories);
        modelAndView.setViewName("inventory/inv_init_qty_maint");
        return modelAndView;
    }

    @RequestMapping("/add.action")
    public String add(Inventory inventory) {
        System.out.println(inventory);

        Inventory add = inventoryService.add(inventory);
        if (add == null) {
            return null;
        }
        return "inventory/inv_init_qty_maint";
    }

    @RequestMapping("/update.action")
    public String update(Integer id, String clientCode, String itemCode, Integer initialNum) {
        Inventory inventory = inventoryService.findOne(id);
        inventory.setInitialNum(initialNum);
        inventory.getClient().setCode(clientCode);
        inventory.getItem().setCode(itemCode);
        Inventory update = inventoryService.update(inventory);
        if (update == null) {
            return null;
        }
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
            session.setAttribute("inventory", inventory);
            return 3;
        }
        return null;
    }
}



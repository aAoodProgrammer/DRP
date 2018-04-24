package com.drp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.drp.pojo.Inventory;
import com.drp.service.IInventoryService;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Resource
    private IInventoryService inventoryService;

    /**
     * 增加
     *
     * @return
     */
    @PostMapping("/add")
    public Inventory add(@RequestBody Inventory inventory) {
        String code = inventory.getClient().getCode();
        System.out.println(code);
        return inventoryService.add(inventory);
    }

    /**
     * 删除
     *
     * @return
     */
    @DeleteMapping("/delete.action")
    public String deleteByIds(List<Integer> ids) {
        inventoryService.deleteByIds(ids);
        return "";
    }

    /**
     * 修改
     *
     * @return
     */
    @PutMapping("/update.action")
    public String update(@RequestBody Inventory inventory) {
        inventoryService.update(inventory);
        return "inventory/inv_init_qty_modify.jsp";
    }

    /**
     * 根据id查
     */
    @GetMapping("")
    public String findOne(Integer id) {
        inventoryService.findOne(id);
        return "";
    }

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
}



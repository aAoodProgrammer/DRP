package com.drp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.drp.pojo.Inventory;
import com.drp.service.IInventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private IInventoryService inventoryService = null;
	
	/**
	 * 增加
	 * @return
	 */
	@PostMapping("/add.action")
	public String add(Inventory inventory) {
		inventoryService.add(inventory);
		return "";
	}
	
	/**
	 * 删除
	 * @return
	 */
	@DeleteMapping("/delete.action")
	public String delete(List<Integer> ids) {
		inventoryService.delete(ids);
		return "";
	}
	
	/**
	 * 修改
	 * @return
	 */
	@PutMapping("/update.action")
	public String update(Inventory inventory) {
		inventoryService.update(inventory);
		return "";
	}
	
	/**
	 * 根据id查
	 */
	@GetMapping("")
	public String findById(Integer id) {
		inventoryService.findById(id);
		return "";
	}

	/**
	 * 查询所有
	 */
	@RequestMapping("/inv_init_qty_maint.action")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("inventories",inventoryService.findByConditions(1, 10));
		modelAndView.setViewName("inventory/inv_init_qty_maint.jsp");
		return modelAndView;
	}
}

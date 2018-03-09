package com.drp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.drp.dto.CategoryDto;
import com.drp.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @ClassName: UserController
 * @Description: 用户控制层
 * @author 刘江涛
 * @date 2017年11月1日 下午2:36:15
 *
 */

@Controller
public class ClientController {
	
	@Autowired
	private IClientService clientService = null;

	@RequestMapping("getPie.action")
	@ResponseBody
	public List<CategoryDto> getClientPieData() {
		
		List<CategoryDto> categoryDtoList = clientService.findByClientLevel();
		
		return categoryDtoList;
	}
}

package com.drp.controller;

import java.util.List;

import javax.annotation.Resource;

import com.drp.dto.CategoryDto;
import com.drp.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘江涛
 * @ClassName: UserController
 * @Description: 用户控制层
 * @date 2017年11月1日 下午2:36:15
 */

@Controller
public class ClientController {

    @Resource
    private IClientService clientService = null;

    @RequestMapping("getPie.action")
    @ResponseBody
    public List<CategoryDto> getClientPieData() {
        List<CategoryDto> categoryDtos = clientService.findByClientLevel();
        return categoryDtos;
    }
}

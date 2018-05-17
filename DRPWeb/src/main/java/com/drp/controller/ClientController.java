package com.drp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.drp.dto.CategoryDto;
import com.drp.pojo.Client;
import com.drp.service.IClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘江涛
 * @ClassName: UserController
 * @Description: 分销商控制层
 * @date 2017年11月1日 下午2:36:15
 */

@Controller
@RequestMapping( "/client" )
public class ClientController {

    @Resource
    private IClientService clientService;

    @RequestMapping( "/findAllClient.action" )
    @ResponseBody
    public Boolean findAll(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Client> clients = clientService.findAll();
        session.setAttribute("clients", clients);
        return clients != null;
    }

    @RequestMapping( "/choiceOne.action" )
    @ResponseBody
    public Object choiceOne(@RequestParam( "ids" ) String ids) {
        if (ids.length() == 0) {
            return 0;
        }
        if (ids.contains("-")) {
            return 1;
        }
        if (!ids.contains("-")) {
            return clientService.findOne(Integer.parseInt(ids));
        }
        return null;
    }
}

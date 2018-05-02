package com.drp.controller;

import com.drp.dto.FlowCardDto;
import com.drp.dto.InventoryDto;
import com.drp.pojo.*;
import com.drp.repository.ClientRepository;
import com.drp.repository.FlowCardMainRepository;
import com.drp.repository.ItemRepository;
import com.drp.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flowCard")
public class FlowCardMainController {
    @Resource
    private FlowCardMainRepository flowCardMainRepository;
    @Resource
    private ClientRepository clientRepository;
    @Resource
    private UserRepository userRepository;

    @RequestMapping("/flow_card_maint.action")
    public ModelAndView findAllByStatus0() {
        ModelAndView modelAndView = new ModelAndView();
        List<FlowCardMain> flowCardMains = flowCardMainRepository.findAllByStatus0();
        List<FlowCardDto> flowCardDtos = new ArrayList<>();
        for (FlowCardMain flowCardMain : flowCardMains) {
            Integer clientId = flowCardMain.getClientId();
            Client client = clientRepository.findById(clientId);
            Integer recoeder = flowCardMain.getRecoeder();
            User user = userRepository.findOne(recoeder);
            Date recoedDate = flowCardMain.getRecoedDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time = format.format(recoedDate);
            flowCardDtos.add(new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), client.getName(),
                    user.getUserName(), time));
        }
        modelAndView.addObject("flowCardDtos", flowCardDtos);
        modelAndView.setViewName("inventory/flow_card_maint");
        return modelAndView;
    }

    @RequestMapping("/flow_card_audit.action")
    public ModelAndView findAllByStatus1() {
        ModelAndView modelAndView = new ModelAndView();
        List<FlowCardMain> flowCardMains = flowCardMainRepository.findAllByStatus01();
        List<FlowCardDto> flowCardDtoList = new ArrayList<>();
        for (FlowCardMain flowCardMain : flowCardMains) {
            Integer clientId = flowCardMain.getClientId();
            Client client = clientRepository.findById(clientId);
            Integer recoeder = flowCardMain.getRecoeder();
            User user = userRepository.findOne(recoeder);
            Date recoedDate = flowCardMain.getRecoedDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time = format.format(recoedDate);
            flowCardDtoList.add(new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), client.getName(),
                    user.getUserName(), time));
        }
        modelAndView.addObject("flowCardDtoList", flowCardDtoList);
        modelAndView.setViewName("inventory/flow_card_audit");
        return modelAndView;
    }
}

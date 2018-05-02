package com.drp.controller;

import com.drp.dto.FlowCardDto;
import com.drp.pojo.*;
import com.drp.repository.ClientRepository;
import com.drp.repository.FlowCardMainRepository;
import com.drp.repository.ItemRepository;
import com.drp.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private ItemRepository itemRepository;
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
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(recoedDate);
            flowCardDtoList.add(new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), client.getName(),
                    user.getUserName(), time));
        }
        modelAndView.addObject("flowCardDtoList", flowCardDtoList);
        modelAndView.setViewName("inventory/flow_card_audit");
        return modelAndView;
    }

    @RequestMapping("/add.action")
    public String add(String clientCode, String itemCode, Integer initialNum) {
        FlowCardMain flowCardMain = new FlowCardMain();
        Client client = clientRepository.findByCode(clientCode);
        Item item = itemRepository.findByCode(itemCode);
        flowCardMain.setClientId(client.getId());
        flowCardMain.setItemId(item.getId());
        flowCardMain.setInitialNum(initialNum);
        flowCardMain.setRecoedDate(new Date());
        flowCardMain.setRecoeder(1);
        flowCardMain.setStatus(0);
        FlowCardMain saveAndFlush = flowCardMainRepository.saveAndFlush(flowCardMain);
        Integer id = saveAndFlush.getId();
        saveAndFlush.setFlowCardNum(id.toString());
        flowCardMainRepository.saveAndFlush(saveAndFlush);
        return "inventory/flow_card_maint";
    }

    @RequestMapping("/delete.action")
    @ResponseBody
    public void delete(@RequestParam(value = "ids", required = false) String ids) {
        if (ids.contains("-")) {
            String[] idArray = ids.split("-");
            for (String id : idArray) {
                flowCardMainRepository.delete(Integer.parseInt(id));
            }
        } else {
            flowCardMainRepository.delete(Integer.parseInt(ids));
        }
    }

    @RequestMapping("/update.action")
    public String update(Integer id, String clientCode) {
        FlowCardMain flowCardMain = flowCardMainRepository.findOne(id);
        Client client = clientRepository.findByCode(clientCode);
        flowCardMain.setClientId(client.getId());
        flowCardMainRepository.saveAndFlush(flowCardMain);
        return "inventory/flow_card_maint";
    }

    @RequestMapping("/modify.action")
    public String modify(Integer id, String clientCode, String itemCode, Integer initialNum, String adjustReason) {
        FlowCardMain flowCardMain = flowCardMainRepository.findOne(id);
        Client client = clientRepository.findByCode(clientCode);
        Item item = itemRepository.findByCode(itemCode);
        flowCardMain.setClientId(client.getId());
        flowCardMain.setInitialNum(initialNum);
        flowCardMain.setItemId(item.getId());
        flowCardMain.setAdjustReason(adjustReason);
        flowCardMainRepository.saveAndFlush(flowCardMain);
        return "inventory/flow_card_maint";
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
            FlowCardMain flowCardMain = flowCardMainRepository.findOne(Integer.parseInt(ids));
            Client client = clientRepository.findOne(flowCardMain.getClientId());
            Item item = itemRepository.findOne(flowCardMain.getItemId());
            User user = userRepository.findOne(flowCardMain.getRecoeder());
            Date recoedDate = flowCardMain.getRecoedDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(recoedDate);
            FlowCardDto flowCardDto = new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), user.getUserName(), time);
            flowCardDto.setAdjustReason(flowCardMain.getAdjustReason());
            flowCardDto.setItemCode(item.getCode());
            flowCardDto.setInitialNum(flowCardMain.getInitialNum());
            session.setAttribute("flowCardDto", flowCardDto);
            return 3;
        }
        return null;
    }

    @RequestMapping("/findOne1.action")
    @ResponseBody
    public Integer findOne1(@RequestParam("ids") String ids, HttpServletRequest request) {
        if (ids.length() == 0) {
            return 0;
        }
        if (ids.contains("-")) {
            return 1;
        }
        if (!ids.contains("-")) {
            HttpSession session = request.getSession();
            FlowCardMain flowCardMain = flowCardMainRepository.findOne(Integer.parseInt(ids));
            Client client = clientRepository.findOne(flowCardMain.getClientId());
            Item item = itemRepository.findOne(flowCardMain.getItemId());
            User user = userRepository.findOne(flowCardMain.getRecoeder());
            Date recoedDate = flowCardMain.getRecoedDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(recoedDate);
            FlowCardDto flowCardDto = new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), user.getUserName(), time);
            flowCardDto.setAdjustReason(flowCardMain.getAdjustReason());
            flowCardDto.setItemCode(item.getCode());
            flowCardDto.setInitialNum(flowCardMain.getInitialNum());
            session.setAttribute("flowCardDto1", flowCardDto);
            return 3;
        }
        return null;
    }

    @RequestMapping("/submitForCensorship.action")
    @ResponseBody
    public Integer submitForCensorship(@RequestParam("ids") String ids) {
        if (ids.length() == 0) {
            return 0;
        }
        if (ids.contains("-")) {
            return 1;
        }
        if (!ids.contains("-")) {
            FlowCardMain flowCardMain = flowCardMainRepository.findOne(Integer.parseInt(ids));
            flowCardMain.setStatus(1);
            flowCardMainRepository.saveAndFlush(flowCardMain);
            return 3;
        }
        return null;
    }

    @RequestMapping("/shenhe.action")
    @ResponseBody
    public Integer shenhe(@RequestParam("ids") String ids) {
        if (ids.length() == 0) {
            return 0;
        }
        if (ids.contains("-")) {
            return 1;
        }
        if (!ids.contains("-")) {
            FlowCardMain flowCardMain = flowCardMainRepository.findOne(Integer.parseInt(ids));
            flowCardMain.setStatus(2);
            flowCardMain.setReviewDate(new Date());
            flowCardMain.setReviewer(1);
            flowCardMainRepository.saveAndFlush(flowCardMain);
            return 3;
        }
        return null;
    }
}

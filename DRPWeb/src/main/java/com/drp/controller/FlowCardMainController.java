package com.drp.controller;

import com.drp.dto.FlowCardDto;
import com.drp.dto.InventoryDto;
import com.drp.pojo.*;
import com.drp.repository.ClientRepository;
import com.drp.repository.FlowCardMainRepository;
import com.drp.repository.ItemRepository;
import com.drp.repository.UserRepository;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( "/flowCard" )
public class FlowCardMainController {
    @Resource
    private FlowCardMainRepository flowCardMainRepository;
    @Resource
    private ClientRepository clientRepository;

    @Resource
    private ItemRepository itemRepository;
    @Resource
    private UserRepository userRepository;

    @RequestMapping( "/findAll.action" )
    @ResponseBody
    public String findAll() {
        List<FlowCardMain> flowCardMains = flowCardMainRepository.findAllByStatus0();
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
        JSONArray jsonArray = JSONArray.fromObject(flowCardDtoList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flowCardDtoList", jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping( "/findAll1.action" )
    @ResponseBody
    public String findAll1() {
        List<FlowCardMain> flowCardMains = flowCardMainRepository.findAllByStatus01();
        List<FlowCardDto> flowCardDtoList1 = new ArrayList<>();
        for (FlowCardMain flowCardMain : flowCardMains) {
            Integer clientId = flowCardMain.getClientId();
            Client client = clientRepository.findById(clientId);
            Integer recoeder = flowCardMain.getRecoeder();
            User user = userRepository.findOne(recoeder);
            Date recoedDate = flowCardMain.getRecoedDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(recoedDate);
            flowCardDtoList1.add(new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), client.getName(),
                    user.getUserName(), time));
        }
        JSONArray jsonArray = JSONArray.fromObject(flowCardDtoList1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flowCardDtoList1", jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping( "/add.action" )
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

    @RequestMapping( "/delete.action" )
    @ResponseBody
    public void delete(@RequestParam( value = "ids", required = false ) String ids) {
        if (ids.contains("-")) {
            String[] idArray = ids.split("-");
            for (String id : idArray) {
                flowCardMainRepository.delete(Integer.parseInt(id));
            }
        } else {
            flowCardMainRepository.delete(Integer.parseInt(ids));
        }
    }

    @RequestMapping( "/update.action" )
    public String update(Integer id, String clientCode) {
        FlowCardMain flowCardMain = flowCardMainRepository.findOne(id);
        Client client = clientRepository.findByCode(clientCode);
        flowCardMain.setClientId(client.getId());
        flowCardMainRepository.saveAndFlush(flowCardMain);
        return "inventory/flow_card_maint";
    }

    @RequestMapping( "/modify.action" )
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

    @RequestMapping( "/findOne.action" )
    @ResponseBody
    public Integer findOne(@RequestParam( "ids" ) String ids, HttpServletRequest request) {
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

    @RequestMapping( "/findOne1.action" )
    @ResponseBody
    public Integer findOne1(@RequestParam( "ids" ) String ids, HttpServletRequest request) {
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

    @RequestMapping( "/submitForCensorship.action" )
    @ResponseBody
    public Integer submitForCensorship(@RequestParam( "ids" ) String ids) {
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

    @RequestMapping( "/shenhe.action" )
    @ResponseBody
    public Integer shenhe(@RequestParam( "ids" ) String ids) {
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

    @RequestMapping( "/search.action" )
    @ResponseBody
    public String search(String beginDate, String endDate, String clientCode) {
        if (beginDate != null && endDate != null && clientCode.equals("")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate1 = null;
            Date endDate1 = null;
            try {
                beginDate1 = format.parse(beginDate);
                endDate1 = format.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<FlowCardMain> flowCardMains = flowCardMainRepository.findAllByTime(beginDate1, endDate1);
            List<FlowCardDto> flowCardDtoList = new ArrayList<>();
            for (FlowCardMain flowCardMain : flowCardMains) {
                Integer clientId = flowCardMain.getClientId();
                Client client = clientRepository.findById(clientId);
                Integer recoeder = flowCardMain.getRecoeder();
                User user = userRepository.findOne(recoeder);
                Date recoedDate = flowCardMain.getRecoedDate();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = format1.format(recoedDate);
                flowCardDtoList.add(new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), client.getName(),
                        user.getUserName(), time));
            }
            JSONArray jsonArray = JSONArray.fromObject(flowCardDtoList);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("flowCardDtoList", jsonArray);
            return jsonObject.toString();
        } else if (!clientCode.equals("") && (beginDate == null || beginDate.equals("")) && (endDate == null || endDate.equals(""))) {
            Client byCode = clientRepository.findByCode(clientCode);
            List<FlowCardMain> flowCardMains = flowCardMainRepository.findAllByClientId(byCode.getId());
            List<FlowCardDto> flowCardDtoList = new ArrayList<>();
            for (FlowCardMain flowCardMain : flowCardMains) {
                Integer clientId = flowCardMain.getClientId();
                Client client = clientRepository.findById(clientId);
                Integer recoeder = flowCardMain.getRecoeder();
                User user = userRepository.findOne(recoeder);
                Date recoedDate = flowCardMain.getRecoedDate();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = format1.format(recoedDate);
                flowCardDtoList.add(new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), client.getName(),
                        user.getUserName(), time));
            }
            JSONArray jsonArray = JSONArray.fromObject(flowCardDtoList);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("flowCardDtoList", jsonArray);
            return jsonObject.toString();
        } else {
            Client byCode = clientRepository.findByCode(clientCode);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate1 = null;
            Date endDate1 = null;
            try {
                beginDate1 = format.parse(beginDate);
                endDate1 = format.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<FlowCardMain> flowCardMains = flowCardMainRepository.findAllByTimeAndClientId(beginDate1, endDate1, byCode.getId());
            List<FlowCardDto> flowCardDtoList = new ArrayList<>();
            for (FlowCardMain flowCardMain : flowCardMains) {
                Integer clientId = flowCardMain.getClientId();
                Client client = clientRepository.findById(clientId);
                Integer recoeder = flowCardMain.getRecoeder();
                User user = userRepository.findOne(recoeder);
                Date recoedDate = flowCardMain.getRecoedDate();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = format1.format(recoedDate);
                flowCardDtoList.add(new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), client.getName(),
                        user.getUserName(), time));
            }
            JSONArray jsonArray = JSONArray.fromObject(flowCardDtoList);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("flowCardDtoList", jsonArray);
            return jsonObject.toString();
        }
    }

    @RequestMapping( "/search1.action" )
    @ResponseBody
    public String search1(String beginDate, String endDate, String clientCode) {
        if (beginDate != null && endDate != null && clientCode.equals("")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate1 = null;
            Date endDate1 = null;
            try {
                beginDate1 = format.parse(beginDate);
                endDate1 = format.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<FlowCardMain> flowCardMains = flowCardMainRepository.findAllByTime1(beginDate1, endDate1);
            List<FlowCardDto> flowCardDtoList1 = new ArrayList<>();
            for (FlowCardMain flowCardMain : flowCardMains) {
                Integer clientId = flowCardMain.getClientId();
                Client client = clientRepository.findById(clientId);
                Integer recoeder = flowCardMain.getRecoeder();
                User user = userRepository.findOne(recoeder);
                Date recoedDate = flowCardMain.getRecoedDate();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = format1.format(recoedDate);
                flowCardDtoList1.add(new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), client.getName(),
                        user.getUserName(), time));
            }
            JSONArray jsonArray = JSONArray.fromObject(flowCardDtoList1);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("flowCardDtoList1", jsonArray);
            return jsonObject.toString();
        } else if (!clientCode.equals("") && (beginDate == null || beginDate.equals("")) && (endDate == null || endDate.equals(""))) {
            Client byCode = clientRepository.findByCode(clientCode);
            List<FlowCardMain> flowCardMains = flowCardMainRepository.findAllByClientId1(byCode.getId());
            List<FlowCardDto> flowCardDtoList1 = new ArrayList<>();
            for (FlowCardMain flowCardMain : flowCardMains) {
                Integer clientId = flowCardMain.getClientId();
                Client client = clientRepository.findById(clientId);
                Integer recoeder = flowCardMain.getRecoeder();
                User user = userRepository.findOne(recoeder);
                Date recoedDate = flowCardMain.getRecoedDate();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = format1.format(recoedDate);
                flowCardDtoList1.add(new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), client.getName(),
                        user.getUserName(), time));
            }
            JSONArray jsonArray = JSONArray.fromObject(flowCardDtoList1);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("flowCardDtoList1", jsonArray);
            return jsonObject.toString();
        } else {
            Client byCode = clientRepository.findByCode(clientCode);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate1 = null;
            Date endDate1 = null;
            try {
                beginDate1 = format.parse(beginDate);
                endDate1 = format.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<FlowCardMain> flowCardMains = flowCardMainRepository.findAllByTimeAndClientId1(beginDate1, endDate1, byCode.getId());
            List<FlowCardDto> flowCardDtoList1 = new ArrayList<>();
            for (FlowCardMain flowCardMain : flowCardMains) {
                Integer clientId = flowCardMain.getClientId();
                Client client = clientRepository.findById(clientId);
                Integer recoeder = flowCardMain.getRecoeder();
                User user = userRepository.findOne(recoeder);
                Date recoedDate = flowCardMain.getRecoedDate();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = format1.format(recoedDate);
                flowCardDtoList1.add(new FlowCardDto(flowCardMain.getId(), flowCardMain.getFlowCardNum(), client.getCode(), client.getName(),
                        user.getUserName(), time));
            }
            JSONArray jsonArray = JSONArray.fromObject(flowCardDtoList1);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("flowCardDtoList1", jsonArray);
            return jsonObject.toString();
        }
    }
}

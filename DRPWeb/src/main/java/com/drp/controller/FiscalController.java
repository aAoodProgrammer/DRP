package com.drp.controller;

import com.drp.pojo.Fiscal;
import com.drp.service.IFiscalService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 刘江涛
 * @ClassName: FiscalController
 * @Description:
 * @date 2018/4/30 11:21
 */
@SessionAttributes( value = {"fiscal"} )
@Controller
public class FiscalController {

    @Resource
    private IFiscalService iFiscalService;


    /**
     * 获取Fiscal的所有信息
     *
     * @return
     */
    @RequestMapping( value = "/getFiscalAll.action", method = RequestMethod.GET )
    @ResponseBody
    public String getFiscalAll() {
        List<Fiscal> fiscalList = iFiscalService.findAll();

        //去掉外键
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter((source, name, value) -> name.equals("flowCardMains") || name.equals("inventories"));

        JSONArray jsonArray = JSONArray.fromObject(fiscalList, jsonConfig);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fiscalList", jsonArray);
        return jsonObject.toString();
    }

    /**
     * 添加一个Fiscal
     *
     * @param fiscal
     * @return
     */
    @RequestMapping( value = "/addFiscal.action", method = RequestMethod.POST )
    @ResponseBody
    public String addFiscal(Fiscal fiscal) {
        fiscal.setId(null);
        if (fiscal.getPeriodFlag() == null) {
            fiscal.setPeriodFlag("否");
        } else {
            fiscal.setPeriodFlag("是");
        }
        iFiscalService.add(fiscal);
        return "success";
    }

    /**
     * 获取需要修改的Fiscal信息
     *
     * @param id
     * @return
     */
    @RequestMapping( value = "/getOneFiscal.action", method = RequestMethod.GET )
    @ResponseBody
    public String getOneFiscal(Integer id, Map<String, Object> map) {
        Fiscal fiscal = iFiscalService.findOne(id);
        map.put("fiscal", fiscal);
        return "success";
    }

    /**
     * 修改Fiscal
     *
     * @param fiscal
     * @return
     */
    @RequestMapping( value = "/updateFiscal.action", method = RequestMethod.POST )
    @ResponseBody
    public String updateFiscal(Fiscal fiscal) {
        if (fiscal.getPeriodFlag().equals("on")) {
            fiscal.setPeriodFlag("是");
        } else {
            fiscal.setPeriodFlag("否");
        }
        iFiscalService.update(fiscal);
        return "success";
    }

}

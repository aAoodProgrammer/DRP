package com.drp.controller;

import com.drp.pojo.Fiscal;
import com.drp.service.IFiscalService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
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
@SessionAttributes(value = {"fiscal"})
@Controller
public class FiscalController {

    @Resource
    private IFiscalService iFiscalService;


    /**
     * 获取Fiscal的所有信息
     * @return
     */
    @RequestMapping(value = "/getFiscalAll.action",method = RequestMethod.GET)
    @ResponseBody
    public String getFiscalAll(){
        System.out.println("请求Fiscal的数据");
        List<Fiscal> fiscalList = iFiscalService.findAll();
        System.out.println("======fiscalList=======");
        System.out.println(fiscalList);
        System.out.println("=============");

        //去掉外键
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            @Override
            public boolean apply(Object sorce, String name, Object value) {
                if (name.equals("flowCardMains") || name.equals("inventories")) {
                    return true;
                }
                return false;
            }
        });

        JSONArray jsonArray = JSONArray.fromObject(fiscalList,jsonConfig);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fiscalList",jsonArray);
        System.out.println("======jsonObject=======");
        System.out.println(jsonObject.toString());
        System.out.println("=============");
        return jsonObject.toString();
    }

    /**
     * 添加一个Fiscal
     * @param fiscal
     * @return
     */
    @RequestMapping(value = "/addFiscal.action",method = RequestMethod.POST)
    @ResponseBody
    public String addFiscal(Fiscal fiscal){
        System.out.println("保存的fiscal的信息:" + fiscal);
        if(fiscal.getPeriodFlag() == null){
            fiscal.setPeriodFlag("否");
        }else {
            fiscal.setPeriodFlag("是");
        }
        iFiscalService.add(fiscal);
        return "success";
    }

    /**
     * 获取需要修改的Fiscal信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getOneFiscal.action",method = RequestMethod.GET)
    @ResponseBody
    public String getOneFiscal(Integer id, Map<String,Object> map){
        Fiscal fiscal = iFiscalService.findOne(id);
        map.put("fiscal",fiscal);
        return "success";
    }

    /**
     * 修改Fiscal
     * 即使前端没有传递id过来，Fiscal中的id一样能够设置正确，是因为查询出来的Fiscal放在了session中，因此
     * 没有传递过来的id，从session中获取到了
     * @param fiscal
     * @return
     */
    @RequestMapping(value = "/updateFiscal.action",method = RequestMethod.POST)
    //@ResponseBody
    public String updateFiscal(Fiscal fiscal){
        System.out.println("修改的fiscal:" + fiscal);
        iFiscalService.update(fiscal);
        return "basicData/fiscal_year_period_maint";
    }

}

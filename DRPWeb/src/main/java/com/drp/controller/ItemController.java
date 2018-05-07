package com.drp.controller;

import com.drp.pojo.Fiscal;
import com.drp.pojo.Item;
import com.drp.service.IItemService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 刘江涛
 * @ClassName: ItemController
 * @Description:
 * @date 2018/5/1 15:03
 */
@SessionAttributes("item")
@Controller
public class ItemController {

    @Resource
    private IItemService iItemService;

    /**
     * 查询所有Item的信息
     *
     * @return
     */
    @GetMapping("/getItemAll.action")
    @ResponseBody
    public String getItemAll() {
        List<Item> itemList = iItemService.findAll();
        //去掉外键
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter((source, name, value) -> name.equals("user") || name.equals("flowCardDetail")
                || name.equals("inventories") || name.equals("itemType") || name.equals("unitType"));
        JSONArray jsonArray = JSONArray.fromObject(itemList, jsonConfig);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("itemList", jsonArray);
        return jsonObject.toString();
    }

    /**
     * 添加一个item
     *
     * @param item
     * @return
     */
    @RequestMapping(value = "/addItem.action", method = RequestMethod.POST)
    @ResponseBody
    public String addItem(Item item) {
        item.setId(null);
        iItemService.add(item);
        return "success";
    }

    /**
     * 获取需要修改的item
     *
     * @return
     */
    @RequestMapping(value = "/getOneItem.action", method = RequestMethod.GET)
    @ResponseBody
    public String getOneItem(Integer id, Map<String, Object> map) {
        Item item = iItemService.findOne(id);
        map.put("item", item);
        return "success";
    }

    @RequestMapping(value = "/updateItem.action", method = RequestMethod.POST)
    @ResponseBody
    public String updateItem(Item item) {
        System.out.println("修改的Item:" + item);
        iItemService.update(item);
        return "success";
    }

    @RequestMapping(value = "/deleteItem.action", method = RequestMethod.POST)
    @ResponseBody
    public String deleteItem(String ids) {
        List<Integer> idsList = new ArrayList<Integer>();
        //判断是否有“-”，没有就表示只删除一个
        if (ids.contains("-")) {
            //用“-”截取loginids
            String[] idsStrings = ids.split("-");
            for (String idString : idsStrings) {
                idsList.add(Integer.parseInt(idString));
            }
        } else {
            idsList.add(Integer.parseInt(ids));
        }
        iItemService.deleteByIds(idsList);
        return "success";
    }

}

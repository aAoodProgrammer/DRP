package com.drp.controller;

import com.drp.pojo.Item;
import com.drp.repository.ItemRepository;
import com.drp.service.IItemService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
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
@SessionAttributes( "item" )
@Controller
public class ItemController {

    @Resource
    private IItemService iItemService;

    @Resource
    private ItemRepository itemRepository;

    /**
     * 查询所有Item的信息
     *
     * @return json
     */
    @GetMapping( "/getItemAll.action" )
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
     * @param item 物料信息
     * @return string
     */
    @RequestMapping( value = "/addItem.action", method = RequestMethod.POST )
    @ResponseBody
    public String addItem(Item item) {
        item.setId(null);
        iItemService.add(item);
        return "success";
    }

    /**
     * 获取需要修改的item
     *
     * @return string
     */
    @RequestMapping( value = "/getOneItem.action", method = RequestMethod.GET )
    @ResponseBody
    public String getOneItem(Integer id, Map<String, Object> map) {
        Item item = iItemService.findOne(id);
        map.put("item", item);
        return "success";
    }

    @RequestMapping( value = "/updateItem.action", method = RequestMethod.POST )
    @ResponseBody
    public String updateItem(Item item) {
        System.out.println("修改的Item:" + item);
        iItemService.update(item);
        return "success";
    }

    @RequestMapping( value = "/deleteItem.action", method = RequestMethod.POST )
    @ResponseBody
    public String deleteItem(String ids) {
        List<Integer> idsList = new ArrayList<>();
        //判断是否有“-”，没有就表示只删除一个
        getIDList(ids, idsList);
        iItemService.deleteByIds(idsList);
        return "success";
    }

    static void getIDList(String ids, List<Integer> idsList) {
        if (ids.contains("-")) {
            //用“-”截取loginIds
            String[] idsStrings = ids.split("-");
            for (String idString : idsStrings) {
                idsList.add(Integer.parseInt(idString));
            }
        } else {
            idsList.add(Integer.parseInt(ids));
        }
    }

    /**
     * 根据物料id和名字查询
     *
     * @return string
     */
    @GetMapping( "/findByItemIdAndName.action" )
    @ResponseBody
    public String findByItemIdAndName(String itemCodeOrName) {
        //查询所有物料
        List<Item> itemList = iItemService.findAll();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray;
        List<Item> items = new ArrayList<>();
        //去掉外键
        //创建一个jsonConfig对象
        JsonConfig jsonConfig = new JsonConfig();
        //设置属性过滤器，排除不需要的属性，即去除外键
        jsonConfig.setJsonPropertyFilter((source, name, value) -> name.equals("user") || name.equals("flowCardDetail")
                || name.equals("inventories") || name.equals("itemType") || name.equals("unitType"));
        //遍历物料list，进行匹配
        for (Item item : itemList) {
            String code = item.getCode();
            String name = item.getName();
            if (code.equals(itemCodeOrName) && !name.contains(itemCodeOrName)) {
                //通过物料代码查询
                Item byCode = itemRepository.findByCode(itemCodeOrName);
                items.add(byCode);
            } else if (!code.equals(itemCodeOrName) && name.contains(itemCodeOrName)) {
                //通过物料名称模糊查询
                Item byName = itemRepository.findByName(name);
                items.add(byName);
            } else if (code.equals(itemCodeOrName) && name.contains(itemCodeOrName)) {
                //若输入关键词既和物料代码一样，又包含在名称里，通过物料代码模糊查询
                Item byCode = itemRepository.findByCode(itemCodeOrName);
                items.add(byCode);
            }
        }
        //将需要的物料list放入json数组
        jsonArray = JSONArray.fromObject(items, jsonConfig);
        //将json数组放入json对象，以便传回前端
        jsonObject.put("itemList", jsonArray);
        return jsonObject.toString();
    }
}

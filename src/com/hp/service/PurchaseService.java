package com.hp.service;

import com.hp.bean.Purchase;
import com.hp.dao.PurchaseDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseService {

    // 全查
    public Map selectAllByParam(){
        PurchaseDao purchaseDao = new PurchaseDao();
        List<Map> cs = purchaseDao.selectAll();

        Map map = new HashMap();
        //  map.put("code",0); //必须和layui的json 返回的格式一样
        map.put("code",0);
        map.put("msg","数据查询成功");
        map.put("data",cs);
        // 根据layui的格式 去封装数据 如果不一样,需要layui解析.
        return map;
    }


    // 增加
    public Map addPurchase(Purchase purchase){
        PurchaseDao dao = new PurchaseDao();
        int i = dao.addPurchase(purchase);

        Map codeMap = new HashMap();
        if (i == 1) {
            codeMap.put("code",0);
            codeMap.put("msg","添加成功");
        }else{
            codeMap.put("code",400);
            codeMap.put("msg","添加失败");
        }
        return codeMap;
    }

}

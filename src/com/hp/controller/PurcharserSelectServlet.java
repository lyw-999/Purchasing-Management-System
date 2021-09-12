package com.hp.controller;

import com.alibaba.fastjson.JSONObject;
import com.hp.service.PurchaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PurcharserSelectServlet" ,urlPatterns = "/PurcharserSelectServlet")
public class PurcharserSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 修正编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html ; charset=UTF-8");
//        //2.接受 2个参数 page limit
//
//        String page = req.getParameter("page");
//        String limit = req.getParameter("limit");
//          打个桩  测bug
        String  pType = req.getParameter("pType");
         System.out.println("pType = " + pType);
        String  pName = req.getParameter("pName");
        System.out.println("pName = " + pName);
        String  pUnit = req.getParameter("pUnit");
        System.out.println("pUnit = " + pUnit);
        String  pNum = req.getParameter("pNum");
        System.out.println("pNum = " + pNum);
        String  pPerson = req.getParameter("pPerson");
       System.out.println("pPerson = " + pPerson);
         String  paDate = req.getParameter("paDate");
      System.out.println("paDate = " + paDate);
        String  paSatate = req.getParameter("paSatate");
        System.out.println("paSatate = " + paSatate);


        Map paramMap = new HashMap();
        paramMap.put("pType",pType);
        paramMap.put("pName",pName);
        paramMap.put("pUnit",pUnit);
        paramMap.put("pNum",pNum);
        paramMap.put("pPerson",pPerson);
        paramMap.put("paDate",paDate);
        paramMap.put("paSatate",paSatate);

        PurchaseService service = new PurchaseService();
        Map map = service.selectAllByParam();

        String s = JSONObject.toJSONString(map);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}

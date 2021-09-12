package com.hp.dao;
import java.util.Date;

import com.hp.bean.Approval;
import com.hp.bean.Purchase;
import com.hp.util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseDao {
    //全查
    public List<Map> selectAll() {
        // String  pName = (String) map.get("pName");
        //1.打开连接
        Connection connection = DBHelper.getConnection();
        //2. 书写sql语句
        String sql = "select t1.*,t2.paDate,t2.paId,t2.paState from tbl_purchase as t1 join tbl_pur_approval as t2 on t1.pId=t2.pId";
//        if (null != pName && pName.length()>0) {
//            sql = sql + " and pName like '%" +pName +"%' ";
//        }
        System.out.println("dao 的 sql = " + sql);
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            //3. 预编译对象
            ps = connection.prepareStatement(sql);
            // 4.执行sql
            rs = ps.executeQuery();
            while (rs.next()){
                Map dataMap = new HashMap();
                dataMap.put("pId",rs.getInt("pId"));
                dataMap.put("pType",rs.getString("pType"));
                dataMap.put("pName",rs.getString("pName"));
                dataMap.put("pUnit",rs.getString("pUnit"));
                dataMap.put("pNum",rs.getInt("pNum"));
                dataMap.put("pPerson",rs.getString("pPerson"));
                dataMap.put("paId",rs.getInt("paId"));
                dataMap.put("paDate",rs.getString("paDate"));
                dataMap.put("paState",rs.getString("paState"));

                list.add(dataMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    // 添加
    public int addPurchase(Purchase purchase){
        //第一步 创建连接对象
        Connection connection = DBHelper.getConnection();
        //第二步  sql语句
        String sql ="insert into tbl_purchase values (null ,?,?,?,?,? )";

        PreparedStatement ps =null;
        int i =0;
        try {
            //第三步 预编译 sql
            ps =  connection.prepareStatement(sql);
            ps.setString(1,purchase.getpType());
            ps.setString(2,purchase.getpName());
            ps.setString(3,purchase.getpUnit());
            ps.setInt(4,purchase.getpNum());
            ps.setString(5,purchase.getpPerson());
//            ps.setInt(6,purchase.getPaID());
//            ps.setString(7,  purchase.getPaDate());
//            ps.setString(8,purchase.getPaState());

            //第四步 执行预编译对象
            i =ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }


    public int addApproval(Approval approval){
        //第一步 创建连接对象
        Connection connection = DBHelper.getConnection();
        //第二步  sql语句
        String sql ="insert into tbl_purchase values (null ,?,?,? ,?)";

        PreparedStatement ps =null;
        int i =0;
        try {
            //第三步 预编译 sql
            ps =  connection.prepareStatement(sql);
            ps.setInt(1,approval.getPaID());
            ps.setInt(2,approval.getpId());
            ps.setString(3,approval.getPaDate());
            ps.setString(4,approval.getPaState());
//            ps.setInt(6,purchase.getPaID());
//            ps.setString(7,  purchase.getPaDate());
//            ps.setString(8,purchase.getPaState());

            //第四步 执行预编译对象
            i =ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }
    public static void main(String[] args) {
        PurchaseDao dao = new PurchaseDao();
//        // 全查

//        List<Map> maps = dao.selectAll();
//        System.out.println("maps = " + maps);
//        System.out.println("maps.size() = " + maps.size());

        // 添加
//                Purchase purchase = new Purchase();
//              //  purchase.setpId(0);
//                purchase.setpType("办公用品");
//                purchase.setpName("旋转椅");
//                purchase.setpUnit("学府");
//                purchase.setpNum(110);
//                purchase.setpPerson("王小明");
//
//        int i = dao.addPurchase(purchase);
//        System.out.println("i = " + i );
                Approval approval = new Approval();
                approval.setPaID(4);
                approval.setpId(4);
                approval.setPaDate("2020-01-15");
                approval.setPaState("未审批");
                int i = dao.addApproval(approval);
                    System.out.println("i = " + i );

    }


}



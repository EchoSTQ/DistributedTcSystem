package com.se17e.dao.impl;

/**
 * Created by WenJiachen on 2020/6/26.
 */
import java.sql.ResultSet;
import java.sql.SQLException;

import com.se17e.bean.OnOffSql;
import com.se17e.bean.User;
import com.se17e.dao.inter.List_CheckDaoInter;
import com.se17e.util.DBUtil;

public class List_CheckDaoImpl implements List_CheckDaoInter{
    public OnOffSql[] fetch_result(String startDate,String endDate,int roomID) {

        OnOffSql[] pack=null;
        int packNum=0;

        ResultSet rs = null;
        String sql=Get_sql(startDate,endDate,roomID);

        System.out.print(sql);
		/*
		try {
			String getNum="select count(*) from room";
			getNum+=Integer.toString(roomID);
			getNum+=";";

			rs = DBUtil.executeQuery(getNum, null);

			rs.next();//第一次debug,忘了写这一行
			packNum=rs.getInt("count(*)");


		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs != null) rs.close();
				if(DBUtil.connection != null) DBUtil.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/


        try {
            rs = DBUtil.executeQuery(sql, null);

            /*创建返回包*/
            rs.last();
            packNum=rs.getRow();
            pack=new OnOffSql[packNum];
            for(int i =0;i<packNum;i++)
                pack[i]=new OnOffSql();

            /*填充返回包*/
            rs.beforeFirst();
            int j=0;
            while(rs.next()){
                // 通过字段检索
                pack[j].OnOff  = rs.getInt("SWITCH");
                pack[j].aimSpeed=rs.getInt("TARGET_SPEED");
                pack[j].aimTmp=rs.getInt("TARGET_TEMP");
                pack[j].date=rs.getTimestamp("DATE");


                // 输出数据
                System.out.print(j);System.out.print('\n');
                System.out.print(pack[j].OnOff);                System.out.print('\n');
                System.out.print(pack[j].aimSpeed);                System.out.print('\n');
                System.out.print(pack[j].aimTmp);                System.out.print('\n');
                System.out.print(pack[j].date);                System.out.print('\n');
                System.out.print('\n');
                j++;
            }

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(rs != null) rs.close();
                if(DBUtil.connection != null) DBUtil.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pack;
    }


    public String Get_sql(String dateStart,String dateEnd,int roomID) {


        String Start="";
        String End="";
        for(int i=0;i<dateStart.length();i++) {
            if(dateStart.charAt(i)=='.')
                Start+='-';
            else
                Start+=dateStart.charAt(i);
        }

        for(int i=0;i<dateEnd.length();i++) {
            if(dateEnd.charAt(i)=='.')
                End+='-';
            else
                End+=dateEnd.charAt(i);
        }

        Start+=" 00:00:00";
        End+=" 00:00:00";

        //','%Y-%m-%d %H:%i:%s') and date <= STR_TO_DATE('2020-11-31 17:13:12','%Y-%m-%d %H:%i:%s');"
        String sql="select * from room";
        sql+=Integer.toString(roomID)+" where date >= STR_TO_DATE('";

        sql=sql+Start+"','%Y-%m-%d %H:%i:%s') and date <= STR_TO_DATE('";
        sql+=End+"','%Y-%m-%d %H:%i:%s');";

        return sql;
    }
}

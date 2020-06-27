package com.se17e.dao.impl;

import com.se17e.bean.OnOffSql;
import com.se17e.dao.inter.ReceptionistDaoInter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.se17e.util.DBUtil;

public class ReceptionistDaoImpl implements ReceptionistDaoInter {//系统实现前台数据读取
    public OnOffSql[] get_Record(int Room_id, String date_in, String date_out){

        OnOffSql[] pack=null;
        int packNum=0;

        ResultSet rs = null;
        String sql=Get_sql(date_in,date_out,Room_id);

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
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("DATE"));
                System.out.print(timeStamp);System.out.print('\n');
                pack[j].date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timeStamp);

                // 输出数据
                System.out.print(j);System.out.print('\n');
                System.out.print(pack[j].OnOff);                System.out.print('\n');
                System.out.print(pack[j].aimSpeed);                System.out.print('\n');
                System.out.print(pack[j].aimTmp);                System.out.print('\n');
                DateFormat mediumDateFormat = DateFormat.getDateTimeInstance
                        (DateFormat.MEDIUM,DateFormat.MEDIUM);
                System.out.print(mediumDateFormat.format(pack[j].date));                System.out.print('\n');
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

    public String Get_sql(String date_in,String date_out,int Room_id) {

        /*要求输入格式为 2020-05-04 12:00:00*/
        //','%Y-%m-%d %H:%i:%s') and date <= STR_TO_DATE('2020-11-31 17:13:12','%Y-%m-%d %H:%i:%s');"

        String sql="select * from room";
        sql+=Integer.toString(Room_id)+" where date >= STR_TO_DATE('";

        sql=sql+date_in+"','%Y-%m-%d %H:%i:%s') and date <= STR_TO_DATE('";
        sql+=date_out+"','%Y-%m-%d %H:%i:%s');";

        return sql;
    }

    public int put_Record(int Room_id, String date_out, double fee){

        int packNum=0;

        int rs = 0;
        String sql=Get_record_sql(fee,date_out,Room_id);
        System.out.print(sql);

        try {
            rs = DBUtil.executeUpdate(sql, null);
            /*创建返回包*/
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != 0) return -1;
                if(DBUtil.connection != null) DBUtil.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    public String Get_record_sql(double fee,String date_out,int Room_id) {

        /*要求输入格式为 2020-05-04 12:00:00*/
        //','%Y-%m-%d %H:%i:%s') and date <= STR_TO_DATE('2020-11-31 17:13:12','%Y-%m-%d %H:%i:%s');"

        String sql="insert into rdr_record(Roomid,fee,Date) values (";
        sql+=Integer.toString(Room_id)+",";
        sql+=Double.toString(fee)+",";
        sql=sql+"'";
        sql+=date_out+"');";

        return sql;
    }

}

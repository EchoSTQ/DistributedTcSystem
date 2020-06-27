package com.se17e.service;

/**
 * Created by WenJiachen on 2020/6/26.
 */
import java.io.IOException;
/*
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.text.SimpleDateFormat;
*/

//import com.se17e.bean.User;

import com.se17e.bean.globalVariables;
import com.se17e.bean.Report;
import java.sql.*;
import java.util.Date;

import com.se17e.bean.OnOffSql;

import com.se17e.dao.impl.List_CheckDaoImpl;

public class List_CheckService  {
    //	private static final long serialVersionUID = 1L;

/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	*/

    //select * from..获取数据库表装入string

    //接受:日期，报表类型
    //返回:报表数组


    //	public OnOffSql[] get_Query(String sql)
    public Report[] Get_daily_imformation(String date,int type) throws IOException{
        //循环所有房间s
        globalVariables G=new globalVariables();

        Report[] ret=new Report[G.roomNum];

        OnOffSql[] pack=null;
        for(int i=0;i<G.roomNum;i++)
            ret[i]=new Report();


        List_CheckDaoImpl query=new List_CheckDaoImpl();
        for(int i=0;i<G.roomNum;i++) {
            //获得sql语句
            String dateEnd=dateAdd(date,type);

            //查询这个房间这段时间内的结果

            pack=query.fetch_result(date,dateEnd,i+1);
            int length=pack.length;
            ret[0].setSwitchTimes(3);
            if(length==0)	//没有记录
                continue;

            ret[i].setType(type);
            /*
             * 使用时间
             * startInd=开空调对应的条数下标
             * endInd=关空调对应的条数下标
             * */
            int startInd=-1;//标识一次开关的记录
            int endInd=-1;
            int changeStart=-1;//标识一次更换温度风速的记录
            int changeEnd=-1;
            for(int j=0;j<length;) {

                for(;j<length&&pack[j].OnOff!=1;j++)	//目前不是开状态，则一律扫描
                    if(pack[j].OnOff==0)	//关命令
                        ret[i].setSwitchTimes(ret[i].getSwitchTimes()+1);//关，开关次数加一
                    else	//调度成功命令
                        ret[i].setScheduleTimes(ret[i].getScheduleTimes()+1);

                startInd=j;
                if(startInd==length)	//本次查询没有开记录，无法计算服务时间。
                    break;
                //遇到开命令
                changeStart=startInd;	//连续两次开记录可能存在更换参数
                changeEnd=startInd;

                for(j++;j<length&&pack[j].OnOff!=0;j++) {	//不是关命令
                    if(pack[j].OnOff==1) {	//开命令
                        changeEnd=j;
                        if(pack[changeStart].aimSpeed!=pack[changeEnd].aimSpeed)
                            ret[i].setSpeedChangeTimes(ret[i].getSpeedChangeTimes()+1);

                        if(pack[changeStart].aimTmp!=pack[changeEnd].aimTmp)
                            ret[i].setTempChangeTimes(ret[i].getTempChangeTimes()+1);
                        changeStart=changeEnd;
                    }
                    else
                        ret[i].setScheduleTimes(ret[i].getScheduleTimes()+1);
                }

                endInd=j;
                if(endInd==length)//本次查询没有关记录，无法计算服务时间
                    break;

                long during=getDatePoor(pack[startInd].date,pack[endInd].date);

                ret[i].setServiceTime(ret[i].getServiceTime()+during);
            }


            //获取该时间段内所有详单
            //	String[] Check=Get_check(date,type);


        }

        return ret;
    }


    //获取某段时间的详单
    public static String[] Get_check(String date,String dateEnd,int roomID) {

        String[] s={"sd"};;
        return s;
    }

    public static String dateAdd(String dateStart,int type) {

        char dates[] = dateStart.toCharArray();

        String year="";
        String month="";
        String day="";

        String ret="";

        int i=0;
        for(;dates[i]!='.';i++) {
            year+=dates[i];
        }
        i++;

        for(;dates[i]!='.';i++) {
            month+=dates[i];
        }
        i++;
        int len=dateStart.length();

        for(;i<len;i++) {
            day+=dates[i];
        }


        int EndDay=Integer.parseInt(day);
        int EndMonth=Integer.parseInt(month);
        int EndYear=Integer.parseInt(year);

        //没有处理非法输入
        if(type==1) {
            EndDay++;
        }
        else if(type==2) {
            EndDay+=7;
        }
        else if(type==3) {
            EndMonth++;
        }
        else {
            EndYear++;
        }

        if(EndDay>31) {
            EndMonth+=1;
            EndDay-=31;
        }
        if(EndMonth>12) {
            EndMonth-=12;
            EndYear+=1;
        }

        ret+=Integer.toString(EndYear)+'.'+Integer.toString(EndMonth)+'.'+Integer.toString(EndDay);

        return ret;
    }
    public static long getDatePoor(Date nowDate,Date endDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        //	    long day = diff / nd;
        // 计算差多少小时
        //    float hour = diff  / nh;
        // hour=(float)(Math.round(hour*10)/10);
        //    int  ret=(int)hour;
        // 计算差多少分钟
        long min = diff / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return min;
    }/*
	public static String getDatePoor(Date endDate, Date nowDate) {

	    long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    // long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = endDate.getTime() - nowDate.getTime();
	    // 计算差多少天
	    long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
	    long min = diff % nd % nh / nm;
	    // 计算差多少秒//输出结果
	    // long sec = diff % nd % nh % nm / ns;
	    return day + "天" + hour + "小时" + min + "分钟";
	}*/


}

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

    //select * from..��ȡ���ݿ��װ��string

    //����:���ڣ���������
    //����:��������


    //	public OnOffSql[] get_Query(String sql)
    public Report[] Get_daily_imformation(String date,int type) throws IOException{
        //ѭ�����з���s
        globalVariables G=new globalVariables();

        Report[] ret=new Report[G.roomNum];

        OnOffSql[] pack=null;
        for(int i=0;i<G.roomNum;i++)
            ret[i]=new Report();


        List_CheckDaoImpl query=new List_CheckDaoImpl();
        for(int i=0;i<G.roomNum;i++) {
            //���sql���
            String dateEnd=dateAdd(date,type);

            //��ѯ����������ʱ���ڵĽ��

            pack=query.fetch_result(date,dateEnd,i+1);
            int length=pack.length;
            ret[0].setSwitchTimes(3);
            if(length==0)	//û�м�¼
                continue;

            ret[i].setType(type);
            /*
             * ʹ��ʱ��
             * startInd=���յ���Ӧ�������±�
             * endInd=�ؿյ���Ӧ�������±�
             * */
            int startInd=-1;//��ʶһ�ο��صļ�¼
            int endInd=-1;
            int changeStart=-1;//��ʶһ�θ����¶ȷ��ٵļ�¼
            int changeEnd=-1;
            for(int j=0;j<length;) {

                for(;j<length&&pack[j].OnOff!=1;j++)	//Ŀǰ���ǿ�״̬����һ��ɨ��
                    if(pack[j].OnOff==0)	//������
                        ret[i].setSwitchTimes(ret[i].getSwitchTimes()+1);//�أ����ش�����һ
                    else	//���ȳɹ�����
                        ret[i].setScheduleTimes(ret[i].getScheduleTimes()+1);

                startInd=j;
                if(startInd==length)	//���β�ѯû�п���¼���޷��������ʱ�䡣
                    break;
                //����������
                changeStart=startInd;	//�������ο���¼���ܴ��ڸ�������
                changeEnd=startInd;

                for(j++;j<length&&pack[j].OnOff!=0;j++) {	//���ǹ�����
                    if(pack[j].OnOff==1) {	//������
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
                if(endInd==length)//���β�ѯû�йؼ�¼���޷��������ʱ��
                    break;

                long during=getDatePoor(pack[startInd].date,pack[endInd].date);

                ret[i].setServiceTime(ret[i].getServiceTime()+during);
            }


            //��ȡ��ʱ����������굥
            //	String[] Check=Get_check(date,type);


        }

        return ret;
    }


    //��ȡĳ��ʱ����굥
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

        //û�д���Ƿ�����
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
        // �������ʱ��ĺ���ʱ�����
        long diff = endDate.getTime() - nowDate.getTime();
        // ����������
        //	    long day = diff / nd;
        // ��������Сʱ
        //    float hour = diff  / nh;
        // hour=(float)(Math.round(hour*10)/10);
        //    int  ret=(int)hour;
        // �������ٷ���
        long min = diff / nm;
        // ����������//������
        // long sec = diff % nd % nh % nm / ns;
        return min;
    }/*
	public static String getDatePoor(Date endDate, Date nowDate) {

	    long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    // long ns = 1000;
	    // �������ʱ��ĺ���ʱ�����
	    long diff = endDate.getTime() - nowDate.getTime();
	    // ����������
	    long day = diff / nd;
	    // ��������Сʱ
	    long hour = diff % nd / nh;
	    // �������ٷ���
	    long min = diff % nd % nh / nm;
	    // ����������//������
	    // long sec = diff % nd % nh % nm / ns;
	    return day + "��" + hour + "Сʱ" + min + "����";
	}*/


}

package com.se17e.service;

import com.se17e.bean.*;
import com.se17e.dao.impl.ReceptionistDaoImpl;

import java.io.IOException;
import java.text.ParseException;

public class ReceptionistService {
    public RDR[] Get_RDR(int Room_id, String date_in, String date_out) throws IOException{

        globalVariables G=new globalVariables();

        OnOffSql[] pack=null;

        ReceptionistDaoImpl query=new ReceptionistDaoImpl();

        //��ѯ����������ʱ���ڵĽ��
        pack=query.get_Record(Room_id,date_in,date_out);

        RDR[] ret = new RDR[pack.length];   //�����굥
        int j = 0;  //�굥��ѭ������

        for(int i=0;i<pack.length;i++)
        {
            ret[i]=new RDR();
            ret[i].setRoom_id(0);
        }

        int temp = 0;   //״̬��־λ,0Ϊ�أ�1Ϊ��
        for(int i=0;i<pack.length;i++) {
            //���sql���
            if(pack[i].OnOff == 3 && temp == 0)
            {
                temp = 1;
                ret[j].setRoom_id(Room_id);
                ret[j].setRequest_time(pack[i].date);
                ret[j].setFanSpeed(pack[i].aimSpeed);

                if(ret[j].getFanSpeed() == 1)
                    ret[j].setFee_rate(0.33);
                else if(ret[j].getFanSpeed() == 2)
                    ret[j].setFee_rate(0.50);
                else
                    ret[j].setFee_rate(1);
            }
            else if(temp == 1 && (pack[i].OnOff == 0 || pack[i].OnOff == 2))
            {
                temp = 0;
                long mins;
                ret[j].setEndService_time(pack[i].date);
                mins = ((pack[i].date.getTime() - ret[j].getRequest_time().getTime())/(1000*60));
                ret[j].setDuration(mins);
                ret[j].setFee(ret[j].getDuration() * ret[j].getFee_rate());
                j++;
            }

        }

        return ret;
    }

    public Invoice Get_Invoice(int Room_id, String date_in, String date_out, RDR[] ret) throws ParseException {
        globalVariables G = new globalVariables();

        Invoice inv = new Invoice();        //�����˵�
        inv.setDate_in(G.sf.parse(date_in));
        inv.setDate_out(G.sf.parse(date_out));
        inv.setRoom_id(Room_id);
        inv.setTotal_fee(0);

        for (int i = 0; i < ret.length; i++) {
            /* ���sql��� */
            if (ret[i].getRoom_id() == Room_id) {
                inv.setTotal_fee(inv.getTotal_fee() + ret[i].getFee());
            }
        }

        ReceptionistDaoImpl query=new ReceptionistDaoImpl();
        int rs = query.put_Record(inv.getRoom_id(),date_out,inv.getTotal_fee());


        return inv;
    }

}

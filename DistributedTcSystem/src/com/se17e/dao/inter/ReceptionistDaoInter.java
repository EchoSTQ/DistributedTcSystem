package com.se17e.dao.inter;

import com.se17e.bean.OnOffSql;
import com.se17e.bean.RDR;

import java.util.Date;

public interface ReceptionistDaoInter {
    public OnOffSql[] get_Record(int Room_id, String date_in, String date_out);
    public String Get_sql(String date_in,String date_out,int Room_id);
    public int put_Record(int Room_id, String date_out, double fee);
    public String Get_record_sql(double fee,String date_out,int Room_id);
}

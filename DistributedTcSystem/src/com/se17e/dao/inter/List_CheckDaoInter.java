package com.se17e.dao.inter;

/**
 * Created by WenJiachen on 2020/6/26.
 */
import com.se17e.bean.OnOffSql;

public interface List_CheckDaoInter {
    //根据sql从数据库中取数据按照格式保存在OnOffSql中返回
    public OnOffSql[] fetch_result(String startDate,String endDate,int roomID);

    public String Get_sql(String dateStart,String dateEnd,int roomID);
}

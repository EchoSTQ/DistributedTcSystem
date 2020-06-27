package com.se17e.servlet;

import com.se17e.bean.Invoice;
import com.se17e.bean.RDR;
import com.se17e.bean.globalVariables;
import com.se17e.service.ReceptionistService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

public class ReceptionistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //	QueryReport(request, response);
        //��ȡʱ���ַ���
        //	String date = request.getParameter("date"); //"2020.1.1"

        //��ȡ��¼����
        //	int type = Integer.parseInt(request.getParameter("type"));

        //	String msg =QueryReport(date,type);

        String msgs = null;
        try {
            msgs = QueryReport(request,response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //String date = request.getParameter("date");
        response.getWriter().write(msgs);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }

    private String QueryReport(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        String date_in = request.getParameter("date_in");
        String date_out = request.getParameter("date_out");
        int Room_id = Integer.parseInt(request.getParameter("Room_id"));

        //������Ϣ
        String msg = "";
        ReceptionistService query = new ReceptionistService();
        RDR[] ret = query.Get_RDR(Room_id, date_in, date_out);
        Invoice inv = query.Get_Invoice(Room_id, date_in, date_out, ret);

        globalVariables G = new globalVariables();
        int roomNum = G.roomNum;

        //*��Ϊһ�����ݵĿ�ͷ,ÿ�����ݸ���ֵ�Զ��Ÿ������������ɱ��
        String numTostring;

        msg = msg + "�굥��?";

        for (int i = 0; i < ret.length; i++) {
            if(ret[i].getRoom_id() == Room_id)
            {
                msg += '*';

                numTostring = String.valueOf(ret[i].getRoom_id());
                msg = msg + numTostring + ",";

                DateFormat mediumDateFormat = DateFormat.getDateTimeInstance
                        (DateFormat.MEDIUM,DateFormat.MEDIUM);
                numTostring = String.valueOf(mediumDateFormat.format(ret[i].getRequest_time()));
                msg = msg + numTostring + ",";

                numTostring = String.valueOf(mediumDateFormat.format(ret[i].getEndService_time()));
                msg = msg + numTostring + ",";

                numTostring = String.valueOf(ret[i].getDuration());
                msg = msg + numTostring + ",";

                numTostring = String.valueOf(ret[i].getFanSpeed());
                msg = msg + numTostring + ",";

                numTostring = String.valueOf(ret[i].getFee_rate());
                msg = msg + numTostring + ",";
                //msg=msg+numTostring;
                numTostring = String.valueOf(ret[i].getFee()); //end
                msg = msg + numTostring + " ";
            }
        }

        msg = msg + "�˵���?";
        numTostring = String.valueOf(inv.getRoom_id());
        msg = msg + numTostring + ",";
        numTostring = String.valueOf(inv.getTotal_fee());
        msg = msg + numTostring + ",";

        DateFormat mediumDateFormat = DateFormat.getDateTimeInstance
                (DateFormat.MEDIUM,DateFormat.MEDIUM);
        numTostring = String.valueOf(mediumDateFormat.format(inv.getDate_in()));
        msg = msg + numTostring + ",";
        numTostring = String.valueOf(mediumDateFormat.format(inv.getDate_out()));
        msg = msg + numTostring;

        return msg;
    }

}

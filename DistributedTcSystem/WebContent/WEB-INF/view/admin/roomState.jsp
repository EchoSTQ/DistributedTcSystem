<%@ page import="com.se17e.bean.RcPara" %><%--
  Created by IntelliJ IDEA.
  User: 温家琛
  Date: 2020/6/25
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RoomState</title>
</head>
<body>
    <table border="1px" >
        <tr>
            <th>房间号</th>
            <th>模式</th>
            <th>目标温度</th>
            <th>目标风速</th>
        </tr>
        <%
            //获取request域中的数据
            RcPara rc = (RcPara)request.getAttribute("roomState");
        %>
        <tr>
            <td><%=rc.getId() %></td>
            <td><%=rc.getMode() %></td>
            <td><%=rc.getTem() %></td>
            <td><%=rc.getSpeed() %></td>
        </tr>

    </table>
</body>
</html>

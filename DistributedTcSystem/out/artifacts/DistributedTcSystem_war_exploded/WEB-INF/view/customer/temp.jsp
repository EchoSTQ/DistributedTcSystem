<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="shortcut icon" href="favicon.ico"/>
    <link rel="bookmark" href="favicon.ico"/>
    <link href="h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="h-ui/css/H-ui.login.css" rel="stylesheet" type="text/css" />
    <link href="h-ui/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
    <link href="h-ui/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">

    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="h-ui/js/H-ui.js"></script>
    <script type="text/javascript" src="h-ui/lib/icheck/jquery.icheck.min.js"></script>

    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <title>Insert title here</title>
</head>
<body>
<br/>
<p style="font-size: 35px; line-height: 35px; height: 35px;">&nbsp;&nbsp;空调温度调节</p>
<%--&nbsp;&nbsp;&nbsp;&nbsp;--%>

<div class = "row cl">
    <label class="form-label col-5"></label>
    <p style="font-size: 25px; line-height: 30px; height: 30px;">高费率：1度/元 中费率：2度/元 低费率：3度/元</p>
</div>

<div class = "row cl">
    <label class="form-label col-5"></label>
    <p style="font-size: 25px; line-height: 30px; height: 30px;">当前温度：<%=application.getAttribute("currentTemp")%>度</p>
</div>

<div class = "row cl">
    <label class="form-label col-5"></label>
    <p style="font-size: 25px; line-height: 30px; height: 30px;">目标温度：<%=application.getAttribute("targetTemp")%>度</p>
</div>

<%--当前风速通过数据库查询获得--%>
<div class = "row cl">
    <label class="form-label col-5"></label>
    <p style="font-size: 25px; line-height: 30px; height: 30px;">当前风速：<%=application.getAttribute("currentWind")%></p>
</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 温家琛
  Date: 2020/6/25
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>CheckState</title>
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
    <script type="text/javascript">
        $(function(){
            //房间1按钮
            $("#room1Btn").click(function(){
                window.location.href = "AdminServlet?method=toRoomStateView&roomID=1";
            })
        })
    </script>
</head>
<body>
<body>
    <div class="row">
        <br/>
        <div class="formControls col-8 col-offset-1">
            <input id="room1Btn" type="button" class="btn btn-success radius size-L" value="&nbsp;房&nbsp;间&nbsp;1&nbsp;">
        </div>
    </div>
    <div class="row">
        <br/>
        <div class="formControls col-8 col-offset-1">
            <input id="room2Btn" type="button" class="btn btn-success radius size-L" value="&nbsp;房&nbsp;间&nbsp;2&nbsp;">
        </div>
    </div>
    <div class="row">
        <br/>
        <div class="formControls col-8 col-offset-1">
            <input id="room3Btn" type="button" class="btn btn-success radius size-L" value="&nbsp;房&nbsp;间&nbsp;3&nbsp;">
        </div>
    </div>
</body>
</body>
</html>

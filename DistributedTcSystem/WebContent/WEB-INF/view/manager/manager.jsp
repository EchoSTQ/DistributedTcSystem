<%--
  Created by IntelliJ IDEA.
  User: 温家琛
  Date: 2020/6/26
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>分布式温控系统  酒店经理后台</title>
    <link rel="shortcut icon" href="favicon.ico"/>
    <link rel="bookmark" href="favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="easyui/css/default.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src='easyui/js/outlook2.js'> </script>
    <script type="text/javascript">
        var _menus = {"menus":[
                {"menuid":"1","icon":"","menuname":"账单查询",//点击菜单进入sevlet判断要进入哪个菜单页面CheckViewServelet?method=toDayCheckView
                    "menus":[
                        {"menuid":"11","menuname":"打印日账单","icon":"icon-exam","url":"CheckViewServelet?method=toDayCheckView"}
                    ]
                }

            ]};


    </script>
</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
        <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
    </div>
</noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
    <span style="float:right; padding-right:20px;" class="head"><span style="color:red; font-weight:bold;">${user.IDnumber}&nbsp;</span>您好&nbsp;&nbsp;&nbsp;<a href="SystemServlet?method=LoginOut" id="loginOut">安全退出</a></span>
    <span style="padding-left:10px; font-size: 16px; ">BUPT分布式温控系统</span>
</div>
<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
    <div class="footer">Copyright &copy; BUPT By SE17E</div>
</div>
<div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
    <div id="nav" class="easyui-accordion" fit="true" border="false">
        <!--  导航内容 -->
    </div>
</div>

<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
    <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
        <jsp:include page="/WEB-INF/view/admin/welcome.jsp" />
    </div>
</div>

<iframe width=0 height=0 src="refresh.jsp"></iframe>
</body>
</html>
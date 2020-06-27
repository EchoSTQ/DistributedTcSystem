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
    <meta charset="UTF-8">
    <title>Insert title here</title>
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
    <div id="as"></div>
    <script type="text/javascript">
        $(function(){
            //开启电源
            $("#submitBtn").click(function(){
                var data = $("#form").serialize();

                $.ajax({
                    type: "post",
                    url: "CheckServelet?method=powerOn",//"CheckServlet?method=QueryReport",
                    data: data,
                    dataType: "text",
                    success: function(msg){
                        if(1 == 1){
                            $.messager.alert("查询结果", msg, "");
                        } else if("1235" == msg){
                            $.messager.alert("消息提醒", "sj!", "warning");
                        }

                    }
                });
            })
        })
    </script>
</head>



<body>
<div class="header" style="padding: 0;">
    <h2 style="color: white; width: 400px; height: 60px; line-height: 60px; margin: 0 0 0 30px; padding: 0;">分布式温控系统</h2>
</div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">
        <form id="form" class="form form-horizontal" method="post">
            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-8">
                    <input id="" name="date" type="text" placeholder="起始日期:如2020.1.1" class="input-text size-L">
                </div>
            </div>


            <div class="mt-20 skin-minimal" style="text-align: center;">
                <div class="radio-box">
                    <input type="radio" id="radio-2" name="type" checked value="1" />
                    <label for="radio-1">日</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="radio-3" name="type" value="2" />
                    <label for="radio-2">周</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="radio-1" name="type" value="3" />
                    <label for="radio-3">月</label>
                </div>
                <!--
                    酒店管理员按钮
                -->
                <div class="radio-box">
                    <input type="radio" id="radio-4" name="type" value="4" />
                    <label for="radio-4">年</label>
                </div>
            </div>


            <div class="mt-20 skin-minimal" style="text-align: center;">
            </div>

            <div class="row">
                <div class="formControls col-8 col-offset-3">
                    <input id="submitBtn" type="button" class="btn btn-success radius size-L" value="&nbsp;查&nbsp;&nbsp;&nbsp;&nbsp;询&nbsp;">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="footer">Copyright &nbsp; BUPT @ SE17E </div>
</body>

</html>
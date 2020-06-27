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

                alert(data);

                $.ajax({
                    type: "post",
                    url: "ReceptionistServlet?method=Login",//"CheckServlet?method=QueryReport",
                    data: data,
                    dataType: "text",
                    success: function(msg){
                        //var data = msg.split("?");
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
                    <input id="" name="Room_id" type="text" placeholder="房间号:如 1" class="input-text size-L">
                </div>
            </div>

            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-8">
                    <input id="" name="date_in" type="text" placeholder="入住时间:如 2020-01-01 12:00:00" class="input-text size-L">
                </div>
            </div>

            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-8">
                    <input id="" name="date_out" type="text" placeholder="离店时间:如 2020-01-01 12:00:00" class="input-text size-L">
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

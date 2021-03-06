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
    <script type="text/javascript">
        $(function(){
            $("#submitBtn").click(function(){
                var data = $("#form").serialize();

                $.ajax({
                    type: "post",
                    url: "CustomerServlet?method=SetWind",
                    dataType: "text", //返回数据类型
                    data:data,
                    success: function(msg){
                        if("setError" == msg){
                            $.messager.alert("消息提醒", "风速设置失败(当前系统繁忙或检查您的输入)!", "warning");
                        } else if("setSuccess" == msg){
                            // $.messager.alert("消息提醒", "风速设置成功!", "warning");
                            window.location.href = "CustomerViewServlet?method=toWindView";
                        }
                    }
                });
            });

            //设置复选框
            $(".skin-minimal input").iCheck({
                radioClass: 'iradio-blue',
                increaseArea: '25%'
            });
        })
    </script>
    <title>Insert title here</title>
</head>
<body>
<br/>
<p style="font-size: 35px; line-height: 35px; height: 35px;">&nbsp;&nbsp;空调风速调节</p>
<%--&nbsp;&nbsp;&nbsp;&nbsp;--%>

<div class = "row cl">
    <label class="form-label col-5"></label>
    <p style="font-size: 25px; line-height: 30px; height: 30px;">高费率：1度/元 中费率：2度/元 低费率：3度/元</p>
</div>

<div class = "row cl">
    <label class="form-label col-5"></label>
    <p style="font-size: 25px; line-height: 30px; height: 30px;">提示：0代表低风速，1代表中风速，2代表高风速</p>
</div>

<div class = "row cl">
    <label class="form-label col-5"></label>
    <p style="font-size: 25px; line-height: 30px; height: 30px;">当前风速</p>
</div>

<form id="form" class="form form-horizontal" method="post">

    <div class="row cl">
        <label class="form-label col-5"></label>
        <div class="formControls col-5">
            <input id="" name="TargetWind" type="text" placeholder="目标风速(2/1/0)" class="input-text size-L" style="width: 300px;">
        </div>
    </div>

    <div class="row">
        <div class="formControls col-8 col-offset-5">
            <input id="submitBtn" type="button" class="btn btn-success radius size-L" value="&nbsp;更&nbsp;改&nbsp;设&nbsp;置&nbsp;">
        </div>
    </div>
</form>
</body>
</html>
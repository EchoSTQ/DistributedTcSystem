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


    <%--    <script type="text/javascript">--%>
    <%--        function fun()--%>
    <%--        {--%>
    <%--            var roomid = document.getElementById("roomID").value;--%>

    <%--            $.ajax({--%>
    <%--                type : "post",--%>
    <%--                url : "CustomerFunServlet?method=roomID",--%>
    <%--                data : roomid,--%>
    <%--                dataText : "text",--%>
    <%--                success : function(msg) {--%>

    <%--                }--%>
    <%--            })--%>
    <%--        }--%>
    <%--    </script>--%>

    <script type="text/javascript"> //跳转到bill.jsp
    $(function(){
        $("#queryBtn").click(function(){

            var data = $("#form").serialize();
            // var roomid = document.getElementById("roomID").value;

            $.ajax({
                type: "post",
                url: "CustomerServlet?method=QueryBill",
                data: data,
                dataType: "text", //返回数据类型
                success: function(msg){ //跳转到详单页面
                    window.location.href = "CustomerViewServlet?method=toBillView";
                }
            });
        });

        // 设置复选框
        $(".skin-minimal input").iCheck({
            radioClass: 'iradio-blue',
            increaseArea: '25%'
        });
    })
    </script>
</head>

<br/>
<p style="font-size: 35px; line-height: 35px; height: 35px;">&nbsp;&nbsp;空调账单查询</p>

<div class = "row cl">
    <label class="form-label col-5"></label>
    <p style="font-size: 25px; line-height: 30px; height: 30px;">您的房间号是:<%=application.getAttribute("loginRoomID")%></p>
</div>

<div class = "row cl">
    <label class="form-label col-5"></label>
    <p style="font-size: 25px; line-height: 30px; height: 30px;">请确认您的房间号(在下方输入您的房间号)</p>
</div>

<%--<form id="form" class="form form-horizontal" method="post">--%>
<form id="form" class="form form-horizontal" method="post">
    <div class="row cl">
        <label class="form-label col-5"></label>
        <div class="formControls col-5">
            <input id="" name="roomID" type="text" placeholder="房间号" class="input-text size-L" style="width: 300px;">
        </div>
    </div>

    <div class="row">
        <div class="formControls col-8 col-offset-5">
            <input id="queryBtn" type="button" class="btn btn-success radius size-L" value="&nbsp;查&nbsp;询&nbsp;账&nbsp;单&nbsp;">
        </div>
    </div>
</form>

</html>
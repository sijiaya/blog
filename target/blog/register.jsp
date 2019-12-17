<%--
  Created by IntelliJ IDEA.
  User: 23173
  Date: 2019/12/13
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <style type="text/css">
        #userlogin{
            height:20px;
            border-top:150px;
            border-bottom: 20px;
        }
        #box{
            /*阴影*/
            box-shadow: 2px 5px 10px #aaa;
            width: 700px;
            height: 500px;
        }
        body{
            margin-top:100px;
            padding: 20px;
            /* 图片不重叠 */
            background: url("image/3.png") no-repeat scroll;
        }
        input{
            width: 270px;
            height: 37px;
            margin:10px 5px 10px 20px;
        }
        .btn{
            width: 270px;
            height: 45px;
            margin: 10px 10px;
            background-color: white;
        }
        .btn1{
            width: 90px;
            height: 25px;
            margin: 10px 10px;
            background-color: white;
        }
        .text{
            color: #808080;
            text-decoration: none;
            width: 15px;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<a href="homepage.html" style="position: absolute;top: 20px;left: 50px">
    <img src="image/logo.png" alt="微博logo" height="30px" width="90px">
</a>
<div id="userlogin" align="center">
    <form action="register.do" method="post" onsubmit="return check_admin(this);" class="form">
        <fieldset id="box">
            <h2>账户注册</h2>
            <input type="text" name="mobile" placeholder="请输入手机号" ><br>
            <input type="password" name="password"  placeholder="请输入密码"><br>
            <input type="email" name="email" placeholder="请输入电子邮箱"><br>
            <input type="text" name="verify" placeholder="输入验证码">
            &nbsp;&nbsp;
            <img src="verifyCode.jsp" width="60px" height="28px" style="vertical-align: middle;"><br>

            <input type="hidden" name="flag" value="1">
            <input type="submit" value="立即登录" class="btn" style="background-color: rgb(255,129,54);color: white;font-weight: bold" /><br>
            <br>

            <input type="reset" value="重置" class="btn1"
                   style="border: none; background-color: white; color: #808080; font-size: 11px"/>
            <a href="login.html" style="color:rgb(255,129,54); ">已有账号，直接登录！</a>
        </fieldset>
    </form>
</div>
</body>
</html>

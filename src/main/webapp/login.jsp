<%--
  Created by IntelliJ IDEA.
  User: 23173
  Date: 2019/12/13
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
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
            border: none;
          }
        .btn1{
            width: 90px;
            height: 25px;
            margin: 10px 10px;
            background-color: white;
            border: none;
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
<a href="#" style="position: absolute;top: 20px;left: 50px">
    <img src="image/logo.png" alt="微博logo" height="30px" width="90px">
</a>
<div id="userlogin" align="center">
    <form action="login.do" method="post" onsubmit="return check_admin(this);" class="form">
        <fieldset id="box">
            <h2>账户登录</h2>
            <input type="text" name="mobile" placeholder="请输入手机号" ><br>
            <input type="password" name="password"  placeholder="请输入密码"><br>

            <input type="text" name="verify" placeholder="输入验证码" autocomplete="off"><br>
            &nbsp;&nbsp;
            <img src="verifyCode.jsp" width="60px" height="28px" style="vertical-align: middle;"><br>


            <input type="submit" value="登录" class="btn" style="background-color: rgb(255,129,54);
            color: white;font-weight: bold"/><br>
            <input type="button"  value="使用QQ直接登录" class="btn"
                   onclick="location.href='https://passport.weibo.com/othersitebind/authorize?entry=miniblog&site=qq'"/>
            <br>

            <label style="padding-left: 60px;  color: #808080;font-size: 14px;" >
                <input type="checkbox" tabindex="5" checked="checked" class="text" style="padding-left: 80px">
                下次自动登录
            </label>
            <input type="reset" value="重置" class="btn1"
                   style="border: none; background-color: white; color: #808080; font-size: 14px"/><br>
            <a href="register.jsp" style="color:rgb(255,129,54); ">立即注册！</a>
        </fieldset>
    </form>
</div>
</body>
</html>

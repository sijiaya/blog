<%--
  Created by IntelliJ IDEA.
  User: 23173
  Date: 2019/12/13
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户退出</title>
</head>
<body>
<script type="text/javascript">
    // 该js 不需要引用，当该页面中所有的内容执行完后自动执行
    onload=function(){
        setInterval(go, 1000);
        //js 中时间以毫秒计时
    };
    var x=1; //利用了全局变量来执行
    function go(){
        x--;
        if(x>0){
            document.getElementById("sp").innerHTML=x+"正在登出";
        }else{
            location.href='index.jsp';
        }
    }
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html;charset=GBK">
	  <title>个人信息修改</title>
   </head>
   <body style="color:orange;text-align:center;font-weight:bold;font-family:Tahoma;">
       <h1>个人信息修改</h1>
	   <hr size="5" color="blue">
   
    <form action="UpdateServlet?flag1=update" method="post" vertical-align:middle>
		<table style="align-content: center">
			<%
				String mobile = request.getParameter("mobile");
				HttpSession hs = request.getSession(true);
				if (mobile!=null&&!mobile.equals("")){
					hs.setAttribute("mobile",mobile);
				}
			%>
			<tr>
				<td>
					帐 号:<input type="password" placeholder="输入账号/手机号" autocomplete="off"><br>
				</td>
				<td>
					密  码:<input type="password" placeholder="输入新密码" autocomplete="off"><br>
				</td>
				<td>
					昵  称:<input type="text" placeholder="输入新昵称" autocomplete="off"><br>
				</td>
				<td>
					简  介:<input type="text" placeholder="输入简介" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<input type="submit" value="修改">
				<input type="reset" value="取消">
			</tr>
		</table>
	</form>
   </body>
<body>
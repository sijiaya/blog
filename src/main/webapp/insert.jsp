<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/10/28
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</head>
<body>
<center>
    <h2>请输入留言信息</h2>
    <form action="NoteServlet?flag=insert" method="post">
        <table border="2">
            <%--<tr>--%>
            <%--<td bgcolor="#a9a9a9">Id</td>--%>
            <%--<td><input type="text" name="Ui" readonly="readonly" ></td>--%>
            <%--</tr>--%>
            <tr>
                <td bgcolor="#a9a9a9">留言id</td>
                <td><input type="text" name="Un"></td>
            </tr>
            <tr>
                <td bgcolor="#a9a9a9">标题</td>
                <td><input type="text" name="Ut" ></td>
            </tr>
            <tr>
                <td bgcolor="#a9a9a9">作者</td>
                <td><input type="text" name="Ua" ></td>
            </tr>
            <tr>
                <td bgcolor="#a9a9a9">内容</td>
                <td><input type="text" name="Uc"></td>
            </tr>
            <tr >
                <td><input type="submit"  value="新增留言"></td>
                <td><input type="reset"  value="重置"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>

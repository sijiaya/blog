<%--
  Created by IntelliJ IDEA.
  User: 23173
  Date: 2019/12/19
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>换肤功能</title>
    <style type="text/css">
        #outer{

        }
    </style>
</head>
<body>
<script type="text/javascript">
    window.onload = function(){
        /*
         * 点击按钮切换图片
         */
        //获取两个按钮
        var prev = document.getElementById("prev");
        var next = document.getElementById("next");
        /*
         * 要切换图片就是要修改img标签的src属性
         */
        //获取img标签
        var img = document.getElementsByTagName("img")[0];

        //创建一个数组，用来保存图片的路径
        var imgArr = ["./image/p2.png" , "./image/p3.png"];
        //创建一个变量，来保存当前正在显示的图片的索引
        var index = 0;
        //获取id为info的p元素
        var info = document.getElementById("info");
        //设置提示文字
        info.innerHTML = "一共 "+imgArr.length+" 张图片，当前第 "+(index+1)+" 张";
        //分别为两个按钮绑定单击响应函数
        prev.onclick = function(){
            /*
             * 切换到上一张，索引自减
             */
            index--;
            //判断index是否小于0
            if(index < 0){
                index = imgArr.length - 1;
            }
            img.src = imgArr[index];
            //当点击按钮以后，重新设置信息
            info.innerHTML = "一共 "+imgArr.length+" 张图片，当前第 "+(index+1)+" 张";
        };
        next.onclick = function(){
            /*
             * 切换到下一张是index自增
             */
            index++;
            if(index > imgArr.length - 1){
                index = 0;
            }
            //切换图片就是修改img的src属性
            //要修改一个元素的属性 元素.属性 = 属性值
            img.src = imgArr[index];
            //当点击按钮以后，重新设置信息
            info.innerHTML = "一共 "+imgArr.length+" 张图片，当前第 "+(index+1)+" 张";
        };
    };
</script>
<div id="outer">
    <img src="./image/p1.png" alt="背景">
</div>

</body>
</html>

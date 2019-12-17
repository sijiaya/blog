<!DOCTYPE html>
<%@ page contentType="text/html; charset=gb2312"%>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<style>
			.img{
				position: absolute; 
				/*让所有图片显示在一个位置，设置绝对位置*/
				opacity: 0;
				animation: Aimg 8s infinite;      /*设置图片轮播一次时间，以及轮播方式（无限循环）*/
			}
			@keyframes Aimg{
				0% {                  /*在百分之零时图片完全不可见*/
					opacity: 0;
				}
				
				1% {
					opacity: 0.3;
				}
				2% {
					opacity: 0.5;
				}
				3% {
					opacity: 0.8;
				}
				4% {                 /*设置这些尽量让图片切换时更加流畅，不突兀*/
					opacity: 1;
				}
				24% {
					opacity: 1;
				}
				
				25% {               /*在此时本张图片显示结束，不透明度设置为0*/
					opacity: 1;
				}
			}
			.img:nth-child(0){animation-delay: 0s;}/*设置下一个子元素延迟时间*/
			.img:nth-child(1){animation-delay: 3s;}
			.img:nth-child(2){animation-delay: 3s;}
			.img:nth-child(3){animation-delay: 3s;}
			.img:nth-child(4){animation-delay: 3s;}
		</style>
	</head>
	<body>
		<div>
			<img src="image/h1.jpg" class="img"/>
			<img src="image/h2.jpg" class="img"/>
			<img src="image/h3.jpg" class="img"/>
			<img src="image/h4.jpg" class="img"/>
			<img src="image/h5.jpg" class="img"/>
		</div>
	</body>
</html>

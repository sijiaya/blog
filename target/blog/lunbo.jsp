<!DOCTYPE html>
<%@ page contentType="text/html; charset=gb2312"%>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<style>
			.img{
				position: absolute; 
				/*������ͼƬ��ʾ��һ��λ�ã����þ���λ��*/
				opacity: 0;
				animation: Aimg 8s infinite;      /*����ͼƬ�ֲ�һ��ʱ�䣬�Լ��ֲ���ʽ������ѭ����*/
			}
			@keyframes Aimg{
				0% {                  /*�ڰٷ�֮��ʱͼƬ��ȫ���ɼ�*/
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
				4% {                 /*������Щ������ͼƬ�л�ʱ������������ͻأ*/
					opacity: 1;
				}
				24% {
					opacity: 1;
				}
				
				25% {               /*�ڴ�ʱ����ͼƬ��ʾ��������͸��������Ϊ0*/
					opacity: 1;
				}
			}
			.img:nth-child(0){animation-delay: 0s;}/*������һ����Ԫ���ӳ�ʱ��*/
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

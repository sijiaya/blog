<!DOCTYPE html>
<!-- 点赞demo，1.png是不亮的图标，2.png是亮的图标，图标自己找 -->
<html>
	<head>
		<meta charset="utf-8">
		<title>点赞</title>	
		<style type="text/css">
		/*        #img{*/
		/*            width:1009px;*/
		/*            height:580px;*/
		/*            margin:302px auto;*/
		/*        }*/
		    </style>
	</head>
	<body>
		<button type="button" id="img">
			<img src="1.png" id="dz">
			</button>
		<script>
			var img1 = document.getElementById("dz");
			//记录获取次数
			var clicks = 1;
			//记录button按钮的点击函数
			img.onclick = function(){
				//如果点击次数除以二的余数为0，就是点了两次（“取消点赞”）
				if(clicks%2==0){
					img1.src="1.png";
				}else{
					//点亮赞
					img1.src="2.png";
				}
				点击次数加1
				clicks++;
			}
		</script>
	</body>
</html>

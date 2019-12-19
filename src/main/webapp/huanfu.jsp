<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style>
		        * {
		            margin: 0;
		            padding: 0;
		        }
		        
		        ul {
		            margin-top: 100px;
		            text-align: top;
		        }
		        
		        li {
		            list-style: none;
		            float: left;
		        }
		        
		        img {
		            width: 10px;
		            vertical-align: top;
					position: relative;
					margin-left: 70px;
									}
									
		        
		        body {
		            background-image: url(img/1.jpg);
		            background-repeat: no-repeat;
		            background-size: 100%;
		        }
				.invite-dialog {
				  margin-left: -144px;
				  position: fixed;
				  left: 50%;
				  width: 288px;
				  min-height: 166px;
				  background: white;
				  border-radius: 3px;
				  margin-top: 22px;
				  z-index: 99;
				}

		    </style>
		
		<body>
		    <ul>
		        <li>
		            <img src="img/1.jpg" alt="">
		        </li>
		        <li>
		            <img src="img/2.jpg" alt="">
		        </li>
		        <li>
		            <img src="img/4.jpg" alt="">
		        </li>
		        <li>
		            <img src="img/6.jpg" alt="">
		        </li>
		    </ul>
		    <script>
		        var imgs = document.querySelectorAll('img');
		        for (var i = 0; i < imgs.length; i++) {
		            imgs[i].onclick = function() {
		                // document.body.style.backgroundImage = url('img/1_4.jpg');
		                var src = this.src;
		                //这样的话，src就成字符串了，而不是变量
		                //document.body.style.backgroundImage = 'url("src")';
		                document.body.style.backgroundImage = 'url(' + src + ')';
		            }
		        }
		    </script>
		</body>
	</head>
	<body>
		
	</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>三生草</title>
    <script language="javascript" src="jquery-1.4.2.js"></script>
    <script language="javascript">var sum = 1;
    function ssss(a){var s = document.getElementById("sd");sum = a;
    s.src = "music/"+sum+".mp3";
    s.play();
    $("#mar")[0].innerText = "当前播放："+$("td:eq("+(sum-1)+")")[0].innerText;
    s.onended = function(){
        s.src = "music/"+sum+".mp3";sum++;
    if(sum == 15){
        sum = 1;
    }
    s.play();
    $("#mar")[0].innerText = "当前播放："+$("td:eq("+(sum-1)+")")[0].innerText}}function ststs(b)
    {
        if(b==2) {
        if($("#sse")[0].value=="播放"){
            $("#sse")[0].value="停止";
            var s = document.getElementById("sd");
    s.pause();
    }else{$("#sse")[0].value="播放";ssss(sum);
    }
    }if(b==1){
        sum--;
        if(sum==0){
            sum=15;
        }ssss(sum);
    }if(b==3){
        sum++;if(sum==16){
            sum=1;
        }
        ssss(sum);
    }
    }
    </script>
</head><body><center><br/><br/>
    <marquee loop id="mar"></marquee>
    <audio id="sd"></audio>
    <br/><input type="button" value="上一首" id="tt" οnclick="ststs(1)"/>
    <input type="button" value="播放" id="sse" οnclick="ststs(2)"/>
    <input type="button" value="下一首" id="mm" οnclick="ststs(3)"/>
    <h2>我的音乐播放器</h2><table style="width:60%;height:300px;">
        <tr><td><a href="https://y.qq.com/n/yqq/song/001dPKD40OUxFz.html" οnclick="ssss('1')">耳朵.m4a</a>
        </td><td><a href="" οnclick="ssss('2')">Sara - 即使知道要见面.mp3</a></td>
        </tr><tr><td><a href="" οnclick="ssss('3')">The Collective - Last Christmas.mp3</a></td>
        <td><a href="" οnclick="ssss('4')">爱情专属权-龙梅子.mp3</a></td>
    </tr><tr><td><a href="" οnclick="ssss('5')">爱人爱人在哪里-马吟吟.mp3</a></td>
        <td><a href="" οnclick="ssss('6')">安琥-会有天使替我爱你.mp3</a></td>
    </tr><tr><td><a href="" οnclick="ssss('7')">安琥-天使的翅膀.mp3</a></td><td><a href="" οnclick="ssss('8')">别用下辈子安慰我-陈瑞.mp3</a></td>
    </tr><tr><td><a href="" οnclick="ssss('9')">陈楚生 - 有没有人曾告诉你.mp3</a></td><td><a href="" οnclick="ssss('10')">陈淑桦 - 梦醒时分.mp3</a></td>
    </tr><tr><td><a href="" οnclick="ssss('11')">丁当 - 手掌心.mp3</a></td><td><a href="" οnclick="ssss('12')">金贵晟 - 虹之间.mp3</a></td>
    </tr><tr><td><a href="" οnclick="ssss('13')">马健南-马航去的地方.mp3</a></td><td><a href="" οnclick="ssss('14')">满江 - 飞鸟.mp3</a></td>
    </tr><tr><td><a href="" οnclick="ssss('15')">不是因为寂寞才想你-雷婷</a></td></tr></table></center></body>
</html>

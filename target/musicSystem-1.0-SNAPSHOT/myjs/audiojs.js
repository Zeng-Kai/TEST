//
document.querySelector(".play-music").onclick =function(){

    var m = document.querySelector("audio");
    if(m.paused == false){
        document.querySelector("i.pause").classList.remove("none");
        document.querySelector("i.play").classList.add("none");
        m.pause();

    }else{
        document.querySelector("i.pause").classList.add("none");
        document.querySelector("i.play").classList.remove("none");
        m.play();
    }
}


// 计算时间
setInterval(function(){
    var m = document.querySelector("audio");
    var musicNowTime = document.querySelector(".musicNowTime");
    var x = parseInt(m.currentTime);
    var nowMin,nowMinInt = parseInt(x/60);
    if(nowMinInt<10) {
        nowMin = "0"+nowMinInt;
    }else{
        nowMin = ""+nowMinInt
    }
    var nowS,nowSInt = x%60;
    if(nowSInt<10) {
        nowS = "0"+nowSInt;
    }else{
        nowS = ""+nowSInt;
    }
    var allMin,allS
    if(parseInt(m.duration)/60<10){
        allMin = "0"+parseInt(parseInt(m.duration)/60);
    }else{
        allMin = ""+parseInt(parseInt(m.duration)/60);
    }
    if(parseInt(parseInt(m.duration)%60)<10){
        allS = "0"+parseInt(parseInt(m.duration)%60);
    }else{
        allS = ""+parseInt(parseInt(m.duration)%60);
    }
    musicNowTime.innerHTML =nowMin+":"+nowS+"/"+allMin+":"+allS;
},10);
// 自动更新
setInterval(function(){
    var m = document.querySelector("audio")
    var ProgressBar = document.querySelector(".ProgressBar");
    var x =(m.currentTime*1.0/m.duration)*((document.querySelector(".allProgressBar").offsetWidth))+"px";
    var ProgressBarBall = document.querySelector(".ProgressBarBall"); // 那个球
    ProgressBar.style.width = x;
    // 球

    ProgressBarBall.style.left = x ;
},10);
// 调节音量
// 判断是否按下或者松开
var flag = false;
// 按下
document.querySelector(".ProgressBarBall").onmousedown =function(e){
    flag = true;

}
// 鼠标位置->audio--->可见
document.onmousemove = function (event) {
    if(flag == true){
        var m = document.querySelector("audio");
        m.currentTime = ((event.clientX - document.querySelector(".allProgressBar").getBoundingClientRect().left)/((document.querySelector(".allProgressBar").offsetWidth)))*m.duration;
    }
}
//无论在哪松开都算false
document.onmouseup =function(e){
    flag = false;
}
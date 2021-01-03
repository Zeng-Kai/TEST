// 更新查询列表 ajax 异步操作
function updeList(url) {
    var xhr= new XMLHttpRequest();
    var responseObj;
    // 建立对服务器的调用
    xhr.open("GET",url);
    xhr.onreadystatechange = function(){
        // 当readyState==4且状态为200时，表示响应就绪
        if(xhr.readyState==4&&xhr.status==200){
            var x = "("+ (xhr.responseText) +")";
            responseObj = eval(x);
            var cul = document.querySelector('.music-list-ul-copy').cloneNode(true);
            cul.className = "music-list-ul";
            document.querySelector('.music-list').appendChild(cul);
            for(var i = 0; i<responseObj.length; i ++){
                // 更新歌曲列表的值
                musicListOp(responseObj[i],i,cul);
            }
        }
    }
    xhr.send(null);
}
// 更新歌曲列表操作
function musicListOp(muisc,i,cul){
    // 歌曲列表结构 .music-list->.music-list-ul->(music-list-li+i)*n
    var cli = document.querySelector('.music-list-li-copy').cloneNode(true);
    cli.className = "music-list-li"+i;
    //-----------
    // 更改链接值
    cli.querySelector('.music-list-a').setAttribute("href","PlayMusicServlet?musicId="+muisc.musicId);
    cli.querySelector('.music-list-a').innerText= "歌名："+muisc.musicName +"   "+"歌手："+muisc.singerName;
    cul.appendChild(cli);
}
// 发送异步请求，在本页面内搜索
document.querySelector(".search-submit").onclick=function () {
    document.querySelector('.music-list').removeChild(document.querySelector('.music-list-ul'));
    updeList("SearchServlet?keyWord="+document.querySelector(".keyWord").value);
}
// --------------------------登录
<!--此js的内容是用于被子页面iframe调用，因为必须要放到前面-->
// closeIframe,当登录成功时，子页面调用
function closeIframe() {
    $(".loginAllBg").addClass("none");
    $(".show-login-box").addClass("none");
}
// 显示登录
$(".show-login").click( function (){

    $(".loginAllBg").removeClass("none");
    $(".show-login-box").removeClass("none");
});
// 取消显示登录
$(".hide-login").click( function (){
    $(".loginAllBg").addClass("none");
    $(".show-login-box").addClass("none");
});
// 判断用户是否登录
function refreshLogin() {
    $.ajax({
        url:"GetUserSessionServlet",
        dataType:"json",
        success:function (data) {
            if(data!=null){
                //说明用户登录了
                $(".login").addClass("none");
                $(".show-li>div>.user-name").html(data.userName);
                //显示用户名的li
                $(".show-li").removeClass("none");
            }else{
                $(".login").removeClass("none");
                $(".show-login>div").html("login");
                //显示用户名的li
                $(".show-li").addClass("none");
            }
        }
    });
    // 设置退出登录
    $(".logout").click(function () {
        $.ajax({
            url:"LogOutServlet",
            dataType:"json"
        });
        refreshLogin();
    });
    // 设置个人主页
    $(".logout").click(function () {
        $.ajax({
            url:"LogOutServlet",
            dataType:"json"
        });
        refreshLogin();
    });
}
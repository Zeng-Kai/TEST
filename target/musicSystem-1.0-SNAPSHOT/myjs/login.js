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
//当点击搜索按钮后，浏览器改变url的值，然后search.html自动执行一次异步请求搜索
document.querySelector(".search-submit").onclick = function () {
    location.href = "search.html?keyWord="+document.querySelector(".keyWord").value;
}
// 判断用户是否登录
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

}
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
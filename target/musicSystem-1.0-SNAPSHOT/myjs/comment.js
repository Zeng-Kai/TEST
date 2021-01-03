// 用户的id，方便评论的时候用,当页面加载的时候，会传值
var userId=-1;
function refreshLogin() {
    $.ajax({
        url:"GetUserSessionServlet",
        dataType:"json",
        success:function (data) {
            if(data!=null){
                //说明用户登录了
                $(".login a>div").html(data.userName);
            }
            userId = data.userId;
        }
    });
}
// 显示评论，利用ajax
function showComment() {
    // 传过来的musicId
    var url = window.location.href.split("?")[1];
    $.ajax({
        url:"CommentServlet?"+url+"&method=find",
        dataType:"json",
        success:function (data) {
            var cul = document.querySelector('.show-comment-ul-copy').cloneNode(true);
            cul.className = "show-comment-ul";
            document.querySelector('.show-comment-box').appendChild(cul);
            for(var i=0;i<data.length;i++){
                var cli = document.querySelector('.show-comment-li-copy').cloneNode(true);
                cli.className = "show-comment-li";
                //-----------
                cli.innerText= "评论人:"+data[i].userName+"内容:"+data[i].commentText+","+data[i].date;
                cul.appendChild(cli);
            }
        }
    });
}
// 发送评论
$(".send-comment-a").click( function () {
    if(userId==-1){
        alert();
        // 等于-1说明没有登录
        // 没有登录则点击登录页面
        $(".login a>div").click();
    }else{
        sendComment();
    }
});
function sendComment() {
    var url = "userId="+userId+"&"+ window.location.href.split("?")[1]+"&commentText="+$(".comment-input")[0].value;
    alert(url);
    $.ajax({
        url:"CommentServlet?"+url+"&method=add",
        dataType:"json",
    });
    // 刷新页面
    window.location.reload()
}
<%--
  Created by IntelliJ IDEA.
  User: Zengkai
  Date: 2020/12/26
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="utf-8">
    <title>${music.musicName}</title>
    <link rel="stylesheet" type="text/css" href="css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css" href="mycss/shouye.css"/>
    <link type="text/css" rel="stylesheet" href="mycss/play.css" />

    <style type="text/css">
        *{
            text-decoration: none;
            list-style: none;
        }
    </style>
    <style>
        .shouye-box .shouye .none{
            display: none;
        }
        /*下拉菜单显示个人主页和退出登录*/
        .show-li-box{
            position: relative;
            top: 10px;
            width: 100px;
            height: 30px;
            background: green;
        }
        /*实现下拉菜单*/
        .show-li-box:hover>.show-li-box-hover{
            display: block;
        }
        /*菜单*/
        .show-li-box-hover{
            display: none;
            position: absolute;
            z-index: 9999;
            top: 30px;
            width: 100px;
            height: 100px;
            background: yellow;
        }
        /*退出登录、个人主页*/
        .show-li-box-hover a{
            display: block;
        }
    </style>
    <style type="text/css">
        .bg-body{
            width: 100%;
            height: 430px;
            background-color: #2b475d;
            border: 1px red solid;
        }
        .bg-body-content-1{
            position: relative;
            left: 200px;
            width: 250px;
            height: 400px;
            align-items: center;
            float: left;

        }
        .big-img{
            width: 230px;
            height: 230px;
        }
        .downloadMusic {
            position: relative;
            left: 40px;
            top: 20px;
            display: block;
            width: 200px;
            height: 50px;
            /* background-color: bisque; */
        }
        .downloadMusic a{


            display: block;
            width: 150px;
            height: 50px;
            border: #6d858f 2px solid;
            color: #6d858f;
        }
        .download-font{
            position: absolute;
            left: 30px;
            top: 15px;

            width: 100px;
            height: 30px;
        }
        .bg-body-content-2{
            position: relative;
            left: 500px;

            width: 400px;
            height: 400px;
            align-items: center;
            float: left;
        }
        .bg-body-content-2-top{
            position: absolute;
            left: 40px;
            width: 300px;
            height: 100px;

        }
        .bg-body-content-2-top-1{
            width: 300px;
            height: 50px;

        }
        .bg-body-content-2-top-2{
            width: 300px;
            height: 50px;

        }
        .audioName{
            float: left;
            font-size: 24px;
            color: white;
        }
        .mv-box{
            position: relative;
            top: 15px;
            left: 5px;
            float: left;
            font-size: 5px;
            width: 20px;
            height: 10px;
            color: #06b0c9;
            border: 2px #06b0c9 solid;
            /* 调节字体的上下 */
            line-height: 80%
        }
        .songerNamelabel{
            float: left;
            font-size: 15px;
            color: #717d8b;
        }
        .songerName{
            float: left;
            font-size: 15px;
            color: white;
        }
    </style>
    <style type="text/css">
        .none{
            display: none;
        }
        audio{
            /* width: 1000px;
            height: 1000px; */
        }


        .allProgressBar{
            position: absolute;
            top: 20px;
            background-color: #545252;

            width: 400px;
            height: 10px;

        }
        .ProgressBar{
            position: absolute;

            width: 100px;
            height: 10px;
            background-color: #11a4f0;
            float: left;
        }
        .ProgressBarBall{
            position: absolute;
            border-radius: 100%;
            background: #dddddd;
            width: 10px;
            height: 10px;
            left: 99px;
        }
        audio{
            display: none;
        }

    </style>
<%--    play2--%>
    <style type="text/css">
        .playThree{
            border: yellow dashed 1px;
            float: left;
            width: 400px;
            height: 100px;
        }
        .collect-a{
           display: block;
            float: left;
            width: 20px;
            height: 20px;
            background-color: palevioletred;
        }
        .comment-a{
            display: block;
            float: left;
            width: 20px;
            height: 20px;
            background-color: palevioletred;
        }
    </style>
    <script type="text/javascript" src="jquery.min.js"></script>
</head>
<body>
<div>
    <div >
        <audio src="music/mid${music.musicId}.mp3" controls="">
            您的浏览器不支持audio标签。
        </audio>
    </div>
    <div class="shouye-box">
        <ul class="shouye">
            <li class="HomePage"><a href="index.html"><div>首页</div></a></li>
            <li class="List"><a href="rank/listenNumber.html"><div>音乐榜单</div></a></li>
            <li class="search">
                <form action="search.html" method="get">
                    <input type="text" class="keyWord" name="keyWord" placeholder="北国之春"/>
                </form>
                <button class="search-submit"><div>搜索</div></button>
            </li>
            <li class="login">
                <a href="javascript:void(0)" class="show-login ">
                    <div></div>
                </a>
            </li>

            <li class="show-li none">
                <div class="show-li-box">
                    <div class="user-name">
                    </div>
                    <div class="show-li-box-hover">
                        <a href="homepage.html" target="_blank" >个人主页</a>
                        <a href="" class="logout">退出登录</a>
                    </div>
                </div>
            </li>
        </ul>
        <div class="loginAllBg none"></div>
        <div class="show-login-box none">
            <div class="hide-login-box"> <a href="javascript:void(0)" class="hide-login"><i class="fa fa-remove"></i></a></div>
            <iframe src="login.html" class="login-iframe" height="200px" width="300px"> </iframe>
        </div>
    </div>

    <!-- 前面要加个fa -->
    <div class="bg-body">
        <div class="bg-body-content-1">
            <img src="images/mid${music.musicId}.png" class="big-img">
            <div class="downloadMusic">
                <a href="javascript:void(0)">
                    <div class="download-font">下载这首歌</div>
                </a>
            </div>
        </div>
        <div class="bg-body-content-2">
            <div class="bg-body-content-2-top">
                <div class="bg-body-content-2-top-1">
                    <div class="audioName">
                        ${music.musicName}
                    </div>
                    <div class="mv-box">mv</div>
                </div>
                <div class="bg-body-content-2-top-2">
                    <div class="songerNamelabel">歌手：</div>
                    <div class="songerName">${music.singerName}</div>
                </div>

            </div>
        </div>
    </div>
    <!-- 播放是固定的 -->
    <div class="play-all">
        <div class="theThree-icon">
            <div class="play-icon-box box1"><a href="#" class="before-music"><i class="fa fa-step-backward"></i></a></div>
            <div class="play-icon-box box2">
                <a href="javascript:void(0)" class="play-music  "><i class="fa fa-play-circle pause"></i><i class="fa fa-pause play none"></i></a>

            </div>

            <div class="play-icon-box box3"><a href="#" class="after-music"><i class="fa fa-step-forward"></i></a></div>
        </div>
        <div class="playTwo">
            <div class="img"><img  class="touxiang" src="images/mid${music.musicId}.png" ></div>

            <div class="barAndfontTime">
                <!-- 进度条上面的文字 -->
                <div class="bar-above">
                    <div class="musicName">${music.singerName}</div>
                    <div class="musicNowTime"> ni1gao1</div>
                </div>
                <!-- 进度条 -->
                <div class="allProgressBarBG">
                    <div class="allProgressBar ">
                        <div class="ProgressBar"></div>
                        <div class="ProgressBarBall"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="playThree">
            <a href="javascript:void(0)" class="collect-a">
                <div>
                    <i class="fa fa-star-o kong"></i>
                    <i class="fa fa-star shi none" ></i>
                </div>
            </a>
            <a href="comment.html?musicId=${music.musicId}" class="comment-a" target="_blank">
                <div>
                    <i class="fa fa-commenting-o" ></i>
                </div>
            </a>
        </div>
    </div>

</body>

<script type="text/javascript" src="myjs/audiojs.js"></script>
<script type="text/javascript" src="myjs/login.js"></script>
<script type="text/javascript" src="myjs/play.js"></script>

<script>
    window.onload=function () {
        // 每次重新打开这个页面的时候进行判断用户是否登录
        loginAndCollect();
        refreshLogin();
    }
</script>
<script>
    // 全局变量，判断是否收藏，默认为不收藏
    var collectFlag = false;
    // 每次重新打开这个页面的时候进行判断用户是否登录
    function loginAndCollect() {
        // 说明登录了
        if("${sessionScope.user.userName}"!=""){
            $(".login a>div").html("${sessionScope.user.userName}");
            //刷新登录图标
            refreshCollect();
        }
        $(".collect-a").click(function () {
            //如果没有登录
            if("${sessionScope.user.userName}"==""){
                // 没有登录则点击登录页面
                $(".login a>div").click();
            }else{
                // 说明登录了，判断是否收藏
                if(collectFlag==true){
                    //已经收藏了，将实心变成空心
                    $(".fa-star-o").removeClass("none");
                    $(".fa-star").addClass("none");
                    $.ajax({// 没变要返回数据
                        url:"CollectServlet?method=delete&musicId=${music.musicId}&userId=${user.userId}"
                    });
                    // collectFlag为false表示当前歌曲当前登录的账户没有收藏
                    collectFlag = false;
                }else {
                    //没有收藏，空心变成实心
                    $(".fa-star-o").addClass("none");
                    $(".fa-star").removeClass("none");
                    $.ajax({// 没变要返回数据
                        url:"CollectServlet?method=add&musicId=${music.musicId}&userId=${user.userId}"
                    });
                    // collectFlag为true表示当前歌曲当前登录的账户收藏了
                    collectFlag = true;
                }
            }
        });
    }
    // 在别的页面登录跳转和点击收藏等登录成之后刷新收藏图标
    function refreshCollect() {
        $.ajax({
            url:"CollectServlet?method=check&musicId=${music.musicId}&userId=${user.userId}",
            dataType:"json",
            success:function (data) {
                if(data==true){
                    // 说明已经收藏了该歌曲，将默认的空心变成实心
                    $(".fa-star-o").addClass("none");
                    $(".fa-star").removeClass("none");
                    collectFlag = true;
                }
            }
        });
    }
</script>
</html>
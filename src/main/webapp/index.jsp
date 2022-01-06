<%--
  Created by IntelliJ IDEA.
  User: lsq_9
  Date: 2021/12/13
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    * {
        margin: 0px;
        padding: 0;
    }
    .nav{
        list-style: none;
        width: 300px;
        margin: 100px auto;
        background: #ffb2a7;
    }
    .nav>li{
        border: 1px solid #000000;
        line-height: 35px;
        border-bottom: none;
        position:relative;
        text-align: center;
    }
    .nav>li:last-child{
        border-bottom: 1px solid #000000;
        border-bottom-right-radius: 10px;
        border-bottom-left-radius: 10px;
    }
    .nav>li:first-child{
        border-top-right-radius: 10px;
        border-top-left-radius: 10px;
    }
    .nav>li>ul{
        list-style: none;
        background: #f8615a;
        display: none;
    }
    .nav>li>ul>li{
        border-top: 1px solid #ffb2a7;
        line-height: 35px;
    }
    .nav>li>ul>li:hover{
        background: #b80d57;
    }
    .nav>li>span{
        background:url("./img/下拉前.png") no-repeat center center;
        display: inline-block;
        width: 32px;
        height: 32px;
        position:absolute;
        right: 10px;
        top: 5px;
    }
</style >
<script src="./lib/jquery-1.11.3/jquery-1.11.3/jquery.min.js"></script>
<script>
    $(function(){
        $(".nav>li").click(function(){
            var $sub =$(this).children(".sub");
            $sub.slideDown(1000);
            var otherSub=$(this).siblings().children(".sub");
            otherSub.slideUp(1000);
        })
    });
</script>
</head>
<body>
<ul class="nav">
    <li>一级菜单一
        <ul class="sub">
            <li>二级菜单</li>
            <li>二级菜单</li>
        </ul>
    </li>
    <li>一级菜单二
        <ul  class="sub">
            <li>二级菜单</li>
            <li>二级菜单</li>
        </ul>
    </li>
    <li>一级菜单三
        <ul  class="sub">
            <li>二级菜单</li>
            <li>二级菜单</li>
        </ul>
    </li>
    <li>一级菜单四
        <ul  class="sub">
            <li>二级菜单</li>
            <li>二级菜单</li>
        </ul>
    </li>
</ul>
</body>
</html>

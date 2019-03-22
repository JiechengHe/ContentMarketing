<%--
  Created by IntelliJ IDEA.
  User: hejiecheng
  Date: 2019/1/7
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>内容营销</title>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script src="js/info.js" type="text/javascript"></script>
    <script src="js/head.js" type="text/javascript"></script>
</head>
<body>

<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            请<a href="Login">[登录]</a>
        </div>
        <ul class="nav">
            <li>
                <a href="/ContentMarketing">首页</a>
            </li>
        </ul>
    </div>
</div>
<div class = "g-doc">
    <div class="n-show f-cb" id="showContent">
        <div class="img">
            <img id="picture" src="">
        </div>
        <div class="cnt">
            <h2 id="title"></h2>
            <p class="summary" id="remark"></p>
            <p class="summary" id="cnt"></p>
            <div class="price">
                <span class="v-unit">￥</span>
                <span class="v-value"></span>
            </div>
            <div class="num">
                购买数量：
                <span id="plusNum" class="lessNum"><a>-</a></span>
                <span class="totalNum" id="allNum">1</span>
                <span id="addNum" class="moreNum"><a>+</a></span>
            </div>
            <div class="oprt f-cb" id="optionDiv"></div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detial"></div>
</div>

</body>
</html>

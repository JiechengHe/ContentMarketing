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
<head>
    <meta charset="UTF-8">
    <title>内容营销</title>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
    <script src="js/cart.js" type="text/javascript"></script>
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
<div class = "g-doc" id="settleAccount">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已添加到购物车的内容</h2>
    </div>
    <table id="newTable" class="m-table m-table-row n-table g-b3">
    </table>
    <div id="act-btn">
        <button class="u-btn u-btn-primary" id="out" onclick="javascript:history.back(-1);">退  出</button>
        <button class="u-btn u-btn-primary" id="account" onclick="buy()">购  买</button>
    </div>
</div>

</body>
</html>

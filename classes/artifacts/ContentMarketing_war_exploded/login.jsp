<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>内容营销</title>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/md5.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
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
    <form class="m-form m-form-ht n-login" id="loginForm" onsubmit="return false;" autocomplete="off">
        <div class="fmitem">
            <label class="fmlab">用户名：</label>
            <div class="fmipt">
                <input class="u-ipt" name="userName" autofocus>
            </div>
        </div>
        <div class="fmitem">
            <label class="fmlab">密码：</label>
            <div class="fmipt">
                <input class="u-ipt" type="password" name="password">
            </div>
        </div>
        <div class="fmitem fmitem-nolab fmitem-btn">
            <div class="fmipt">
                <button type="submit" class="u-btn u-btn-primary u-btn-lg u-btn-block" onclick="login()">
                    登  录
                </button>
            </div>
        </div>
    </form>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: hejiecheng
  Date: 2019/1/7
  Time: 3:23 PM
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
    <script type="text/javascript" src="js/edit.js"></script>
    <script type="text/javascript" src="js/head.js"></script>
    <script type="text/javascript" src="js/ajaxFileUpload.js"></script>
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
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>内容发布</h2>
    </div>
    <div class="n-public">
        <form class="m-form m-form-ht" id="form" onsubmit="return false;" autocomplete="off">
            <div class="fmitem">
                <label class="fmlab">标题：</label>
                <div class="fmipt">
                    <input class="u-ipt ipt" id="title" autofocus placeholder="2-80字符">
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">摘要：</label>
                <div class="fmipt">
                    <input class="u-ipt ipt" id="remark" placeholder="2-140字符">
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">图片：</label>
                <div class="fmipt" id="uploadType">
                    <input name="pic" type="radio" value="url" checked>图片地址
                    <input name="pic" type="radio" value="file">本地上传
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab"></label>
                <div class="fmipt" id="urlUpload">
                    <input class="u-ipt ipt" id="image" placeholder="图片地址">
                </div>
                <div class="fmipt" id="fileUpload" style="display:none">
                    <input class="u-ipt ipt" name="file" type="file" id="fileUp">
                    <button class="u-btn u-btn-primary" id="upload">上传</button>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">正文：</label>
                <div class="fmipt">
                    <textarea class="u-ipt" id="detail" rows="10" placeholder="2-1000个字符"></textarea>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">价格：</label>
                <div class="fmipt">
                    <input class="u-ipt price" id="price">元
                </div>
            </div>
            <div class="fmitem fmitem-nolab fmitem-btn">
                <div class="fmipt">
                    <button type="submit" class="u-btn u-btn-primary u-btn-lg" id="push">发  布</button>
                </div>
            </div>
        </form>
        <span class="imgpre">
            <img src="" id="imgpre">
        </span>
    </div>
</div>

</body>
</html>


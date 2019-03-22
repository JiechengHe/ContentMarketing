<%--
  Created by IntelliJ IDEA.
  User: hejiecheng
  Date: 2019/1/10
  Time: 11:14 AM
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
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script src="js/account.js" type="text/javascript"></script>
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
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup>
            <col class="img"/>
            <col>
            <col class="time"/>
            <col>
            <col class="num"/>
            <col>
            <col class="price"/>
            <col>
        </colgroup>
        <thead align="center">
            <th>内容图片</th>
            <th>内容名称</th>
            <th>购买时间</th>
            <th>购买数量</th>
            <th>购买价格</th>
        </thead>
        <tbody></tbody>
        <tfoot>
            <tr>
                <td colspan="4">
                    <div class="total">总计：</div>
                </td>
                <td>
                    <span class="v-unit">￥</span>
                    <span class="v-value" id="sum"></span>
                </td>
            </tr>
        </tfoot>
    </table>
</div>
</body>
</html>

$(function () {
   var username = $.cookie("username") ;
   addHead(username) ;
   var contentId = $.cookie("contentId") ;
   addContentInfo(contentId, username) ;
   addOption(contentId, username) ;

   $("#plusNum").click(function () {
       var num = $("#allNum").text() ;
       num = parseInt(num) - 1 ;
       if(num <= 0){
           num = 1 ;
       }
       $("#allNum").text(num) ;
   });
    $("#addNum").click(function () {
        var num = $("#allNum").text() ;
        num = parseInt(num) + 1 ;
        $("#allNum").text(num) ;
    });

});

function addContentInfo(contentId,username) {
    $.ajax({
        url : "Content/GetInfo" ,
        type : "GET" ,
        data : {id:contentId} ,
        dataType : "json" ,
        success : function (data) {
            if(data.code == "200"){
                $("#picture").attr("src",data.content.picture) ;
                $("#title").text(data.content.title) ;
                $("#remark").text(data.content.remark) ;
                $("#cnt").text("已售出 " + data.content.cnt + "份") ;
                $(".v-value").text(data.content.price) ;
                if(username != "buyer" || data.content.cnt != 0){
                    $(".num").hide() ;
                }
                if(username == "buyer"){
                    if(data.content.cnt == 0){
                        // 显示购买按钮
                        var newHtml = '<button class="u-btn u-btn-primary" id="add" onclick="Cart('+data.content.id+')">加入购物车</button>' ;
                        $("#optionDiv").append(newHtml) ;
                    }
                    else {
                        // 显示已购买按钮，并显示购买时价格
                        var newHtml = '<span class="u-btn u-btn-primary z-dis">已购买</span>' ;
                        newHtml += '<span class="buyprice">购买时的价格为：￥'+data.content.buyPrice+'</span>' ;
                        $("#optionDiv").append(newHtml) ;
                    }
                }
                $(".n-detial").append(data.content.artical) ;
            }
            else{
                alert("获取商品内容失败!") ;
                location.href = "/ContentMarketing" ;
            }
        }
    });
}

function addOption(contentId, username) {
    if(username == "seller"){
        // 增加一个编辑按钮
        var newHtml = '<a href="ContentEdit?id=' + contentId + '" class="u-btn u-btn-primary">编  辑</a>' ;
        $("#optionDiv").append(newHtml) ;
    }
}

function Cart(contentId) {
    if(confirm("确定购买此内容?")) {
        var num = $("#allNum").text();
        $.ajax({
            url: "Cart",
            type: "POST",
            data: {contentId: contentId, cnt: num},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    alert("加入成功!");
                }
                else {
                    alert("加入失败!");
                }
                location.href = "/ContentMarketing";
            },
            error: function (message) {
                alert("系统出错！");
                location.href = "/ContentMarketing"
            }
        });
    }
}
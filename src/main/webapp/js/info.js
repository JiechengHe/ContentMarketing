$(function () {
   var username = $.cookie("username") ;
   addHead(username) ;
   var contentId = $.cookie("contentId") ;
   addContentInfo(contentId, username) ;
   addOption(contentId, username) ;
});

function addContentInfo(contentId,username) {
    $.ajax({
        url : "Content/Info" ,
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
                if(username != "buyer"){
                    $(".num").hide() ;
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
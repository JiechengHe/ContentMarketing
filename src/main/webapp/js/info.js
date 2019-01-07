$(function () {
   var username = $.cookie("username") ;
   addHead(username) ;
   var contentId = $.cookie("contentId") ;
   addContentInfo(contentId,username) ;
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
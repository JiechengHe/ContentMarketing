$(function () {
   var username = $.cookie("username") ;
   addHead(username) ;

   $('input:radio[name="pic"]').click(function () {
      var checked = $('input:radio[name="pic"]:checked').val() ;
      if(checked == "url"){
        $("#urlUpload").show() ;
        $("#fileUpload").hide() ;
      }
      else{
          $("#urlUpload").hide() ;
          $("#fileUpload").show() ;
      }
   });

    $("#upload").click(function(){
        var maxAllowedSize = 1000000 ;
        var allowType = ['png'] ;
        var uploadInput = $("#fileUp").get(0) ;
        if(uploadInput.files[0].size > maxAllowedSize){
            alert("图片大小超过上传大小限制(1M)") ;
        }
        else if(checkType(uploadInput.files[0].name, allowType) == false){
            alert("文件类型不正确!") ;
        }
        else{
            $.ajaxFileUpload({
                url : "Upload" ,
                type : "POST" ,
                data : {} ,
                dataType : "text" ,
                fileElementId : "fileUp" ,
                secureuri : false,
                async : false,
                success : function (data) {
                    result = JSON.parse(data) ;
                    if(result.code == 200){
                        $("#imgpre").attr("src",result.imgUrl) ;
                    }
                    else{
                        alert("上传失败!") ;
                    }
                },
                error : function (message) {
                    alert(message) ;
                }
            });
        }
    });

    $("#image").blur(function () {
        var imgUrl = $("#image").val() ;
        $("#imgpre").attr("src",imgUrl) ;
    });

    var contentId = $.cookie("contentId") ;
    if(contentId == null){
        $("#push").click(function () {
            // 新增
            var title = $("#title").val() ;
            var remark = $("#remark").val() ;
            var artical = $("#detail").val() ;
            var price = $("#price").val() ;
            var picture = $("#imgpre").attr("src") ;
            if((message = checkContent(title,remark,artical,price,picture)) == null){
                $.ajax({
                    url : "Content/Info" ,
                    type : "PUT" ,
                    data : {title:title,remark:remark,artical:artical,price:price,picture:picture} ,
                    dataType : "json" ,
                    success : function (data) {
                        if(data.code == 200){
                            alert("发布成功!") ;
                            location.href = "/ContentMarketing"
                        }
                        else{
                            alert("发布失败!") ;
                        }
                    },
                    error : function (message) {
                        alert("发布错误!") ;
                        location.href = "/ContentMarketing" ;
                    }
                });
            }
            else{
                alert(message) ;
            }
        });
    }
    else if(contentId >= 0){
        // 获取内容信息
        getContentDetial(contentId) ;
        $("#push").click(function () {
            // 修改
            // 新增
            var title = $("#title").val() ;
            var remark = $("#remark").val() ;
            var artical = $("#detail").val() ;
            var price = $("#price").val() ;
            var picture = $("#imgpre").attr("src") ;
            if((message = checkContent(title,remark,artical,price,picture)) == null){
                $.ajax({
                    url : "Content/Info" ,
                    type : "POST" ,
                    data : {title:title,remark:remark,artical:artical,price:price,picture:picture,id:contentId} ,
                    dataType : "json" ,
                    success : function (data) {
                        if(data.code == 200){
                            alert("修改成功!") ;
                            location.href = "Content?id=" + contentId ;
                        }
                        else{
                            alert("修改失败!") ;
                        }
                    },
                    error : function (message) {
                        alert("系统错误!") ;
                        location.href = "/ContentMarketing" ;
                    }
                });
            }
            else{
                alert(message) ;
            }
        });
    }
});

function checkContent(title, remark, artical, price, picture) {
    if(title.length < 2 || title.length > 80){
        return "标题内容限制为2-80个字符!" ;
    }
    if(remark.length < 2 || remark.length > 140){
        return "摘要内容限制为2-140个字符!" ;
    }
    if(artical.length < 2 || artical.length > 1000){
        return "正文内容限制为2-1000个字符!" ;
    }
    if(price == '' || !Number(price)){
        return "请输入正确的价格!" ;
    }
    if(price.lastIndexOf(".") >= 0 && price.substring(price.lastIndexOf(".") + 1).length > 2){
        return "价格保留两位小数!" ;
    }
    if((price.lastIndexOf(".") >= 0 && price.substring(0,price.lastIndexOf(".")).length > 3)
        ||(price.lastIndexOf(".") < 0 && price.length > 3)){
        return "价格最高为999.99元" ;
    }
    if(picture == null || picture == ''){
        return "请加入图片!" ;
    }
    return null ;
}

function checkType(fileName, allowType) {
    for(var i = 0 ; i < allowType.length ; ++ i){
        if(fileName.substring(fileName.lastIndexOf(".")+1).indexOf(allowType[i]) >= 0){
            return true ;
        }
    }
    return false ;
}

function getContentDetial(contentId){
    $.ajax({
        url : "Content/Info" ,
        type : "GET" ,
        data : {id:contentId} ,
        dataType : "json" ,
        success : function (data) {
            if(data.code == 200){
                content = data.content ;
                $("#title").val(content.title) ;
                $("#remark").val(content.remark) ;
                $("#detail").val(content.artical) ;
                $("#price").val(content.price) ;
                $("#imgpre").attr("src", content.picture) ;
            }
            else{
                alert("获取信息失败失败!") ;
                location.href = "/ContentMarketing" ;
            }
        },
        error : function (message) {
            alert("系统错误!") ;
            location.href = "/ContentMarketing" ;
        }
    });
}
$(function(){
    var user = $.cookie("username") ;
    addHead(user) ;
    showList(user) ;
    hidePart(user) ;
});

function showList(user){
    $.ajax({
        url : "List" ,
        type : "GET" ,
        data : {} ,
        dataType : "json" ,
        success : function (data) {
            if(data.code == "300"){
                alert("获取内容列表失败!") ;
                return ;
            }

            contentData = data.data ;
        //  清空现有的列表
            $("#plist_all").html("") ;
            var newHtml = "" ;
            for(var i = 0 ; i < contentData.length ; ++ i){
                newHtml += '<li id="' + contentData[i].id + '">' ;
                newHtml += '<a href="Content?id=' + contentData[i].id + '" class="link">' ;
                newHtml += '<div class="img">' ;
                newHtml += '<img src="' + contentData[i].picture + '">' ;
                newHtml += '</div>' ;
                newHtml += '<h3>'+ contentData[i].title +'</h3>' ;
                newHtml += '<h3>已售出'+ contentData[i].cnt +'份</h3>' ;
                if(contentData[i].cnt != 0 && user != null){
                    newHtml += '<span class="had">' ;
                    if(user == "buyer"){
                        newHtml += '<b>已购买</b>' ;
                    }
                    else if(user == "seller"){
                        newHtml += '<b>已售出</b>' ;
                    }
                    newHtml += '</span>' ;
                }
                newHtml += '<div class="price">' ;
                newHtml += '<span class="v-unit">￥</span>' ;
                newHtml += '<span class="v-value">'+ contentData[i].price +'</span>' ;
                newHtml += '</div></a>';
                if(user == "seller" && contentData[i].cnt == 0){
                    newHtml += '<span class="u-btn u-btn-normal n-btn-xs del" onclick="deleteContent(\''+contentData[i].id+'\')">' ;
                    newHtml += '删除</span>' ;
                }
                newHtml += '</li>' ;
            }
            $("#plist_all").append(newHtml) ;

            if(user == "buyer"){
                $("#plist_part").html("") ;
                var newHtml = "" ;
                for(var i = 0 ; i < contentData.length ; ++ i){
                    if(contentData[i].cnt != 0){
                        continue ;
                    }
                    newHtml += '<li id="' + contentData[i].id + '">' ;
                    newHtml += '<a href="Content?id=' + contentData[i].id + '" class="link">' ;
                    newHtml += '<div class="img">' ;
                    newHtml += '<img src="' + contentData[i].picture + '">' ;
                    newHtml += '</div>' ;
                    newHtml += '<h3>'+ contentData[i].title +'</h3>' ;
                    newHtml += '<div class="price">' ;
                    newHtml += '<span class="v-unit">￥</span>' ;
                    newHtml += '<span class="v-value">'+ contentData[i].price +'</span>' ;
                    newHtml += '</div></a></li>' ;
                }
                $("#plist_part").append(newHtml) ;
            }
        }
    });
}

function showAll(){
    $("#part").removeClass("z-sel") ;
    $("#all").addClass("z-sel") ;
    $("#plist_all").show() ;
    $("#plist_part").hide() ;
}

function showPart() {
    $("#all").removeClass("z-sel") ;
    $("#part").addClass("z-sel") ;
    $("#plist_all").hide() ;
    $("#plist_part").show() ;
}

function hidePart(username) {
    if(username == null || username == "seller"){
        $("#part").hide() ;
    }
    $("#plist_part").hide() ;
}

function deleteContent(id){
    if(confirm("确认删除该内容")){
        $.ajax({
            url : "Content/Info" ,
            type : "POST" ,
            data : {id:id,_method:"delete"} ,
            dataType : "json" ,
            success : function (data) {
                if(data.code == "200"){
                    alert("删除成功!") ;
                    location.href = "/ContentMarketing" ;
                }
                else{
                    alert("删除失败!") ;
                }
            },
            error : function (message) {
                alert(message) ;
            }
        });
    }
}
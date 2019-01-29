$(function () {
    var username = $.cookie("username") ;
    addHead(username) ;
    $.ajax({
        url : "Cart" ,
        type : "GET" ,
        data : {} ,
        dataType : "json" ,
        success : function (data) {
            data = data.cart ;
            var newHtml = '<tbody><tr><th>内容名称</th><th>数量</th><th>价格</th><th>操作</th></tr>' ;
            for(var i = 0 ; i < data.length ; ++ i){
                newHtml += '<tr id="tr'+data[i].contentId+'"><td>'+ data[i].content.title +'</td>' ;
                newHtml += '<td>' +
                           '<span class="lessNum" onclick="less('+ data[i].contentId +')"><a>-</a></span>' +
                           '<span class="totalNum" id="num'+data[i].contentId+'">'+data[i].cnt+'</span>' +
                           '<span class="moreNum" onclick="more('+ data[i].contentId +')"><a>+</a></span>' +
                           '</td>' ;
                newHtml += '<td>'+ data[i].content.price +'</td>' ;
                newHtml += '<td><button class="u-btn u-btn-primary" onclick="deleteCart('+data[i].contentId+')">删除</button></td>' ;
                newHtml += '</tr></tbody>' ;
            }
            $("#newTable").append(newHtml) ;
            cart = JSON.parse($.cookie("cart")) ;
        },
        error : function (message) {
            alert("系统错误!") ;
        }
    });

});

var cart ;

function less(id) {
    var num = parseInt($("#num"+id).text()) ;
    if(num == 1){
        alert("如果不想要此内容，请删除!") ;
        return ;
    }
    num = num - 1 ;
    $("#num" + id).text(num) ;
    for(var i = 0 ; i < cart.length ; ++ i){
        if(cart[i].contentId == id){
            cart[i].cnt = num ;
        }
    }
}

function more(id) {
    var num = parseInt($("#num"+id).text()) ;
    num = num + 1 ;
    $("#num" + id).text(num) ;
    for(var i = 0 ; i < cart.length ; ++ i){
        if(cart[i].contentId == id){
            cart[i].cnt = num ;
        }
    }
}

function deleteCart(id){
    if(confirm("确定删除此商品!")) {
        $.ajax({
            url: "Cart",
            type: "POST",
            data: {_method: "delete", contentId: id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    alert("删除成功!") ;
                    $("#tr" + id).remove() ;
                    for(var i = 0 ; i < cart.length ; ++ i){
                        if(cart[i].contentId == id){
                            cart.splice(i,1) ;
                        }
                    }
                }
                else{
                    alert("删除失败!") ;
                }
            },
            error : function (message) {
                alert("系统错误!") ;
            }
        });
    }
}

function buy() {
    if(confirm("确认购买这些内容")){
        cartString = JSON.stringify(cart) ;
        $.ajax({
            url: "Order",
            type: "POST",
            data: {cartString:cartString},
            dataType: "json",
            success : function (data) {
                if(data.code == 200){
                    alert("购买成功");
                }
                else{
                    alert("购买失败!");
                }
                location.href = "/ContentMarketing" ;
            },
            error : function (message) {
                alert("系统错误!") ;
            }
        });
    }
}
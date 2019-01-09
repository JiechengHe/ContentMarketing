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
        },
        error : function (message) {
            alert("系统错误!") ;
        }
    });
});

function less(id) {
    var num = parseInt($("#num"+id).text()) ;
    num = num - 1 ;
    $("#num" + id).text(num) ;
}

function more(id) {
    var num = parseInt($("#num"+id).text()) ;
    num = num + 1 ;
    $("#num" + id).text(num) ;
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
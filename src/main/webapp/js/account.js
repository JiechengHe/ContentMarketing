$(function () {
    var username = $.cookie("username") ;
    addHead(username) ;
    $.ajax({
        url: "Account/getAccount",
        type: "POST",
        data: {},
        dataType: "json",
        success : function (data) {
            var newHtml = "" ;
            var sum = 0 ;
            for(var i = 0 ; i < data.length ; ++ i){
                newHtml += '<tr>' ;
                newHtml += '<td><a href="Content?id=' + data[i].contentId + '"><img src="'+data[i].content.picture+'"></a></td>' ;
                newHtml += '<td><h4><a href="Content?id=' + data[i].contentId + '">'+data[i].content.title+'</a></h4></td>' ;
                newHtml += '<td><span class="v-time">'+fmtDate(data[i].order.orderTime)+'</span></td>' ;
                newHtml += '<td><span class="v-num">'+data[i].cnt+'</span></td>' ;
                newHtml += '<td><span class="v-unit">￥</span><span class="value">'+data[i].price+'</span></td>' ;
                newHtml += '</tr>' ;
                sum = sum + (parseInt(data[i].cnt) * parseFloat(data[i].price)) ;
            }
            $("table tbody").append(newHtml) ;
            $("#sum").text(sum) ;
        },
        error : function (message) {
            alert("系统错误!");
        }
    });
});

function fmtDate (unixtimestamp){
    var unixtimestamp = new Date(unixtimestamp*1000);
    var year = 1900 + unixtimestamp.getYear();
    var month = "0" + (unixtimestamp.getMonth() + 1);
    var date = "0" + unixtimestamp.getDate();
    var hour = "0" + unixtimestamp.getHours();
    var minute = "0" + unixtimestamp.getMinutes();
    var second = "0" + unixtimestamp.getSeconds();
    return year + "-" + month.substring(month.length-2, month.length)  + "-" + date.substring(date.length-2, date.length)
        + " " + hour.substring(hour.length-2, hour.length) + ":"
        + minute.substring(minute.length-2, minute.length) + ":"
        + second.substring(second.length-2, second.length);
}

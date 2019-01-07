function addHead(user) {
    if(user == null || (user != "buyer" && user != "seller")){
        $(".user").html("") ;
        var newHtml = '请<a href="Login">[登录]</a>' ;
        $(".user").append(newHtml) ;
        $(".nav").html("") ;
        newHtml = '<li><a href="/ContentMarketing">首页</a></li>' ;
        $(".nav").append(newHtml) ;
    }
    else{
        $(".user").html("") ;
        if(user == "buyer"){
            var newHtml = '买家您好，<span class="name">buyer</span>!' ;
        }
        else if(user == "seller"){
            var newHtml = '卖家您好，<span class="name">seller</span>!' ;
        }
        newHtml += '<a href="logout">[退出]</a>' ;
        $(".user").append(newHtml) ;

        $(".nav").html("") ;
        var newHtml = '<li><a href="/ContentMarketing">首页</a></li>' ;
        if(user == "buyer"){
            newHtml += '<li><a href="account">财务</a></li>' ;
            newHtml += '<li><a href="cart">购物车</a></li>' ;
        }
        else if(user == "seller"){
            newHtml += '<li><a href="ContentEdit?id=-1">发布</a></li>'
        }
        $(".nav").append(newHtml) ;
    }
}
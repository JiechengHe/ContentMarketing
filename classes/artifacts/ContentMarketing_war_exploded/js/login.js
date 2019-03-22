function login(){
    var username = $("input[name='userName']").val() ;
    var password = md5($("input[name='password']").val()) ;
    $.ajax({
        url : "Login" ,
        type : "POST" ,
        data : {username:username,password:password} ,
        dataType : "json" ,
        success : function (data) {
            if(data.code == "200"){
                location.href = "/ContentMarketing";
                return false ;
            }
            else{
                alert("登录失败!") ;
                return false ;
            }
        },
        error : function (message) {
            alert(message||"登录失败!") ;
            return false ;
        }
    });
}
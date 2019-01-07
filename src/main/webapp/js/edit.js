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
            alert("开始上传!") ;
        }
    });
});

function checkType(fileName, allowType) {
    for(var i = 0 ; i < allowType.length ; ++ i){
        if(fileName.indexOf(allowType[i]) >= 0){
            return true ;
        }
    }
    return false ;
}
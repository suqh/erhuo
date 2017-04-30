/**
 * Created by caojx on 17-4-30.
 */
$(document).ready(function () {

    var contactInfo = {};

    /**
     * 获取数据，只获取收获地址信息，其他的订单信息去获取购物车中的信息
     */
    var getDate = function () {
          contactInfo = {
              "orderUserId":$("#userId").val(),
              "orderReceiveAddress":$("#orderReceiveAddress").val(),
              "orderReceiveName":$("#orderReceiveName").val(),
              "orderReceivePhone":$("#orderReceivePhone").val(),
          }
    };

    /**
     * 验证数据
     */
    var validate = function () {
        getDate();
      if(contactInfo.orderReceiveAddress =="" || contactInfo.orderReceiveAddress == null || contactInfo.orderReceiveAddress == undefined){
          alert("收获地址不能为空");
          return false;
      }
        if(contactInfo.orderReceiveName =="" || contactInfo.orderReceiveName == null || contactInfo.orderReceiveName == undefined){
            alert("收件人姓名不能为空");
            return false;
        }
        if(contactInfo.orderReceivePhone =="" || contactInfo.orderReceivePhone == null || contactInfo.orderReceivePhone == undefined){
            alert("收件人手机号码不能为空");
            return false;
        }
        return true;
    };

    /**
     * 初始化事件
     */
    var initEvent = function () {
        $("#confirm").bind("click",function () {
            if(validate()){
                $.ajax({
                    url:"",
                    type:"",
                    data:contactInfo,
                    success:function (data) {
                        if(data.status == 1){
                            //跳转到首页
                        }else{
                            alert(data.error);
                        }
                    }
                });
            }
        });
    }

});
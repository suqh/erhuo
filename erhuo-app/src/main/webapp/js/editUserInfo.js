/**
 * Created by QH on 2017/4/22.
 */

$(document).ready(function () {

    var userInfo = {};

    /*
     * 获取表单数据
     * */
    var getData = function () {
        userInfo = {
            "userId": $("#userId").val(),
            "userName": $("#userName").val(),
            "userGender": $("input[type=radio]:checked").val(),
            "userAge": $("#userAge").val(),
            "userEmail": $("#userEmail").val(),
            "userAddress": $("#userAddress").val(),
            "userPhone": $("#userPhone").val(),
        }
    };

    var validate = function () {
        if (userInfo.userGender == null || userInfo.userGender == "") {
            alert("用户性别不能为空");
            return false;
        }
        if (userInfo.userAge == null || userInfo.userAge == "") {
            alert("用户年龄不能为空");
            return false;
        }
        if (userInfo.userAddress == null || userInfo.userAddress == "") {
            alert("用户地址不能为空");
            return false;
        }
        if (userInfo.userPhone == null || userInfo.userPhone == "") {
            alert("用户手机号码不能为空");
            return false;
        }
        return true;
    };

    var initEvent = function () {
        $("#editBtn").bind("click",function () {
            getData();
            if(validate()){
                $.ajax({
                    url:"/registerAndLogin/editUserInfo.do",
                    type:"post",
                    data:userInfo,
                    success:function (data) {
                        //出错了
                        if(data.status == 0){
                            alert(data.error);
                        }else {
                            alert(data.message);
                            /*location.href="/registerAndLogin/indexPage"*/
                            location.href="/saleList/showSaleList?userId="+data.userId
                        }
                    }
                });
            }
        });
        $("#backBtn").bind("click",function () {
            location.href="/saleList/showSaleList?userId="+$("#userId").val()
        })
    };

    var init = function () {
        initEvent();
    };

    init();
});

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
            "userName":$("#userName").val(),
            "userPassword":$("#userPassword").val(),
            "userGender":$("input[type=radio]:checked").val(),
            "userAge":$("#userAge").val(),
            "userEmail":$("#userEmail").val(),
            "userAdderss":$("#userAdderss").val(),
            "userPhone":$("#userPhone").val(),
        }
    };

    /*
    * 验证参数是否有效
    * */
    var validate = function () {
        if (userInfo.userName == null || userInfo.userName == "") {
            alert("用户名不能为空");
            return false;
        }
        if (userInfo.userPassword == null || userInfo.userPassword == "") {
            alert("用户密码不能为空");
            return false;
        }
        if ($("#confirmPassword").val() != userInfo.userPassword) {
            alert("两次输入密码不一致");
            return false;
        }
        if (userInfo.userGender == null || userInfo.userGender == "") {
            alert("用户性别不能为空");
            return false;
        }
        if (userInfo.userAge == null || userInfo.userAge == "") {
            alert("用户年龄不能为空");
            return false;
        }
        if (userInfo.userAdderss == null || userInfo.userAdderss == "") {
            alert("用户地址不能为空");
            return false;
        }
        if (userInfo.userPhone == null || userInfo.userPhone == "") {
            alert("用户手机号码不能为空");
            return false;
        }
        return true;
    };

    /*
    * 初始化注册事件
    * */
    var initEvent = function () {
        $("#saveBtn").bind("click",function () {
            getData();
            if(validate()){
                $.ajax({
                    url:"/registerAndLogin/register.do",
                    type:"post",
                    data:userInfo,
                    success:function (data) {
                        //出错了
                        if(data.status == 0){
                            alert(data.error);
                        }else {
                            alert(data.message)
                            location.href="/registerAndLogin/loginPage"
                        }
                    }
                });
            }
        })
        $("")
        ;
    };

    /**
     * 初始化
     */
    var init = function () {
      initEvent();
    };

    init();
});


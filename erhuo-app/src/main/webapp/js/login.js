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
            "userName": $("#userName").val(),
            "userPassword": $("#userPassword").val(),
        }
    };

    /*
     * 验证用户名密码是否填写
     * */
    var validate = function () {
        if (userInfo.userName == "" || userInfo.userName == null) {
            alert("用户名不能为空");
            return false;
        }
        if (userInfo.userPassword == "" || userInfo.userPassword == null) {
            alert("密码不能为空");
            return false;
        }
        return true;
    };

    /**
     * 忘记密码通过输入的用户名来修改
     */
    var validate1 = function () {
        if (userInfo.userName == "" || userInfo.userName == null) {
            alert("用户名不能为空");
            return false;
        }
        return true;
    };

    var initEvent = function () {
        $("#loginBtn").bind("click", function () {
            getData();
            if (validate()) {
                $.ajax({
                    url: "/registerAndLogin/login.do",
                    type: "post",
                    data: userInfo,
                    success: function (data) {
                        if (data.status == 1) {
                            location.href = "/saleList/showSaleList?userId=" + data.userId;
                        } else {
                            alert(data.error);
                        }
                    }
                });
            }
        });

        $("#forget_btn").bind("click", function () {
            getData();
            if (userInfo.userName == "" || userInfo.userName == null) {
                alert("用户名不能为空");
            } else {
                location.href = "/forgetPassword/viewEmailPage?userName=" + userInfo.userName;
            }
        });
    };

    var init = function () {
        initEvent();
    };

    init();
});


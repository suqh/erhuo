/**
 * Created by QH on 2017/4/30.
 */
$(document).ready(function () {
    var userInfo = {};

    var getData = function () {
        userInfo = {
            userId: $("#userId").val(),
            userEmail: $("#userEmail").val(),
        }
    };

    var initEvent = function () {
        $("#sendBtn").bind("click", function () {
            getData();
            $.ajax({
                url: "/forgetPassword/sendMail",
                type: "post",
                data: userInfo,
                success: function (data) {
                    if (data.status == 1) {
                        alert(data.message)
                    } else {
                        alert(data.error)
                    }
                }
            })
        })
    };

    var init = function () {
        initEvent();
    };

    init();
});
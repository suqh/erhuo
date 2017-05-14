/**
 * Created by QH on 2017/4/27.
 */
$(document).ready(function () {
    var goodsInfo = {};
    var getData = function () {
        goodsInfo = {
            goodsName: $("#goodsName").val(),
            goodsType: $("#goodsType").val(),
            goodsPrice: $("#goodsPrice").val(),
        }
    };
    /*
    * 初始化事件
    * */
    var initEvent = function () {
        //搜索事件
        $("#searchBtn").click(function () {
            /*getData();*/
            $("#tf").submit();
        });

        //发布商品事件
        $("#sale").bind("click",function () {
            var goodsUserId = $("#userId").val();
            //判断是否登录，没登录跳转到登录界面
            if(goodsUserId == null || goodsUserId == "" || goodsUserId == undefined) {
                location.href="/registerAndLogin/loginPage";
            }else {
                location.href="/saleDetail/saleDetailList.do?goodsUserId="+goodsUserId;
            }
        })
    };
    var init = function () {
        initEvent();
    };
    init();
});

/**
 * 判断下拉框是否选中
 */
function isSelected(value) {
    if (value != null) {
        return "selected";
    }
}
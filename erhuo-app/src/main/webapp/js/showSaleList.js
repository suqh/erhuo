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
    var initEvent = function () {
        $("#searchBtn").click(function () {
            /*getData();*/
            $("#tf").submit();
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
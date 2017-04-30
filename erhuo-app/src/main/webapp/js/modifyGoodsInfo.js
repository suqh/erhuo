/**
 * Created by QH on 2017/4/26.
 */
$(document).ready(function () {

    var goodsInfo = {};

    var getData = function () {
        goodsInfo = {
            fileName: $("#fileName").val(),
            filePath:$("#filePath").val(),
            goodsName: $("#goodsName").val(),
            goodsId: $("#goodsId").val(),
            goodsDesc: $("#goodsDesc").val(),
            tradLocation: $("#tradLocation").val(),
            goodsPrice: $("#goodsPrice").val(),
            goodsType: $("#goodsType").val(),
            phoneNum: $("#phoneNum").val(),
            userId: $("#userId").val(),
            goodsNum: $("#goodsNum").val(),
        };
    }

    var validate = function () {
        /*if(goodsInfo.fileName == null || goodsInfo.fileName == "") {
         alert("请选择要上传的图片");
         return false;
         }*/
        if (goodsInfo.goodsName == null || goodsInfo.goodsName == "") {
            alert("商品名称不能为空");
            return false;
        }
        if (goodsInfo.goodsDesc == null || goodsInfo.goodsDesc == "") {
            alert("商品描述不能为空");
            return false;
        }
        if (goodsInfo.tradLocation == null || goodsInfo.toLocaleString == "") {
            alert("交易地点不能为空");
            return false;
        }
        if (goodsInfo.goodsNum == null || goodsInfo.goodsNum == "") {
            alert("商品数量不能为空");
            return false;
        }
        if (goodsInfo.goodsPrice == null || goodsInfo.goodsPrice == "") {
            alert("商品价格不能为空");
            return false;
        }
        if (goodsInfo.goodsType == null || goodsInfo.goodsType == "") {
            alert("商品类型不能为空");
            return false;
        }
        if (goodsInfo.phoneNum == null || goodsInfo.phoneNum == "") {
            alert("联系方式");
            return false;
        }
        return true;
    };

    var initEvent = function () {
        $("#modifyBtn").click(function () {
            getData();
            if (validate()) {
                $.ajax({
                    url: "/modify/modifyGoodsInfo.do",
                    type: "post",
                    data: goodsInfo,
                    success: function (data) {
                        if (data.status == 0) {
                            alert(data.error);
                        } else {
                            alert(data.message);
                            if(data.goodsId!=null && data.goodsId != undefined){
                                var goodsId = data.goodsId;
                                location.href = "/saleDetail/viewProductDetails?goodsId="+goodsId;
                            }
                        }
                    }
                })
            }
        })
    };

    var init = function () {
        initEvent();
    };

    init();
});



/**
 * Created by QH on 2017/4/24.
 */

function removeGoods(goodsId){
    if(window.confirm("是否删除该商品?")){
        $.ajax({
            url:"/saleDetail/deleteGoods",
            type:"post",
            data: {
                "goodsId":goodsId,
            },
            success:function (data) {
                if (data.status == 0) {
                    alert(data.error);
                }else {
                    alert(data.message);
                    location.href = "/saleDetail/saleDetailList.do";
                }
            }
        });
    }
}

function back() {
    location.href="/saleList/showSaleList"
}
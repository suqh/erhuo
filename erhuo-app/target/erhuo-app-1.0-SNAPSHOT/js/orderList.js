/**
 * Created by QH on 2017/4/24.
 */

function removeGoods(userId,orderId){
    if(window.confirm("是否删除该商品?")){
        $.ajax({
            url:"/order/deleteOrderInfo",
            type:"post",
            data: {
                "userId":userId,
                "orderId":orderId,
            },
            success:function (data) {
                if (data.status == 1) {
                    alert(data.message);
                    location.href = "/order/orderList?userId="+userId;
                }else {
                    alert(data.error);
                }
            }
        });
    }
}

function back() {
    location.href="/saleList/showSaleList"
}
/**
 * Created by QH on 2017/4/24.
 */

function removeShoppingCart(goodsId, userId) {
    if (window.confirm("是否将该商品移除购物车?")) {
        $.ajax({
            url: "/shoppingCart/deleteShoppingCart",
            type: "post",
            data: {
                "goodsId": goodsId,
                "userId": userId,
            },
            success: function (data) {
                if (data.status == 0) {
                    alert(data.error);
                } else {
                    alert(data.message);
                    location.href = "/shoppingCart/shoppingCartPage?userId=" + data.userId;
                }
            }
        });
    }
}

/**
 * 修改商品数量,重新计价格
 */
function editShoppingCart() {
    if($("#number").val() > 0){
        $("#orderOneForm").submit();
    }else {
        alert("商品数量不能小于0");
    }
}


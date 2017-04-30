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

/*结算*/
function isChecked() {
    if ($("#goodsId").checked == true) {
        var groupCheckbox = $("input[name='goodsId']");
        for (i = 0; i < groupCheckbox.length; i++) {
            if (groupCheckbox[i].checked) {
                var goodsPrice = groupCheckbox[i].value;
                alert(goodsPrice);
            }
        }
    }
    if ($("#goodsId").checked == false) {}
    $.ajax({
        url: "",
        type: "post",
        data: {
            "goodsIds": $("#goodsId").val()
        },
        success: function (data) {

        }
    })
}

/**
 * 显示商品总价格
 */
function showTotalPrice(goodsId, price, number) {
    var selectGoods = {};
}
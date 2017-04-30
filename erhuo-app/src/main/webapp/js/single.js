/**
 * Created by QH on 2017/4/28.
 */
$(document).ready(function () {
   var shoppingCartInfo = {}; 
   
   var getData = function () {
       shoppingCartInfo = {
           "shoppingCartName":$("#shoppingCartName").val(),
           "shoppingCartNum":$("#goodsNum").val(),
           "fileName":$("#fileName").val(),
           "filePath":$("#filePath").val(),
           "goodsId":$("#goodsId").val(),
           "userId":$("#userId").val(),
           "goodsPrice":$("#goodsPrice").val(),
           "maxGoodsNum":$("#maxGoodsNum").val(),
       }
   }
   
   var initEvent = function () {
       $("#addCartBtn").click(function () {
           getData();
           $.ajax({
               url:"/shoppingCart/addShoppingCart",
               type:"post",
               data:shoppingCartInfo,
               success:function (data) {
                   if(data.status == 1) {
                       alert(data.message);
                       location.href="/saleDetail/viewProductDetails?goodsId="+shoppingCartInfo.goodsId
                   }else {
                       alert(data.error);
                   }
               }
           })
       })
   }

   var init = function () {
       initEvent();
   }

   init();
});
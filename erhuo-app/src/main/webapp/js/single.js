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
           //没有登录不能加入购物车,跳转到登录界面
           if(shoppingCartInfo.userId == "" || shoppingCartInfo.userId == undefined) {
               location.href="/registerAndLogin/loginPage";
           }else if($("#goodsNum").val()!=0){
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
               });
           }else{
               alert("商品数量不足");
           }
       });

       $("#deleteBtn").click(function () {
           getData();
           if(window.confirm("是否删除该商品?")){
               $.ajax({
                   url:"/saleDetail/deleteGoods",
                   type:"post",
                   data: shoppingCartInfo,
                   success:function (data) {
                       if (data.status == 0) {
                           alert(data.error);
                       }else {
                           alert(data.message);
                           location.href = "/saleList/showSaleList";
                       }
                   }
               });
           }
       })

       $("#continueBtn").click(function () {
           location.href = "/saleList/showSaleList"
       })
   }

   var init = function () {
       initEvent();
   }

   init();
});
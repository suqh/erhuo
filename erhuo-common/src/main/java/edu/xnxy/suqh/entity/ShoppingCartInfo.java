package edu.xnxy.suqh.entity;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/28.
 */
public class ShoppingCartInfo {
    /**
     *购物车id
     */
    private Integer shoppingCartId;

    /**
     *购物车商品名称
     */
    private String shoppingCartName;

    /**
     * 购物车商品数量
     */
    private Integer shoppingCartNum;

    /**
     * 购物车商品图片名称
     */
    private String fileName;

    /**
     * 购物车商品图片路径
     */
    private String filePath;

    /**
     *商品id
     */
    private Integer goodsId;

    /**
     *用户id
     */
    private Integer userId;

    /**
     * 商品价格
     */
    private Integer goodsPrice;

    /**
     * 最大商品数
     */
    private Integer maxGoodsNum;

    /*
   * 扩展字段ext1
   * */
    private Integer ext1;

    /*
    * 扩展字段ext2
    * */
    private String ext2;

    /*
    * 扩展字段ext3
    * */
    private String ext3;


    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public String getShoppingCartName() {
        return shoppingCartName;
    }

    public void setShoppingCartName(String shoppingCartName) {
        this.shoppingCartName = shoppingCartName;
    }

    public Integer getShoppingCartNum() {
        return shoppingCartNum;
    }

    public void setShoppingCartNum(Integer shoppingCartNum) {
        this.shoppingCartNum = shoppingCartNum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getMaxGoodsNum() {
        return maxGoodsNum;
    }

    public void setMaxGoodsNum(Integer maxGoodsNum) {
        this.maxGoodsNum = maxGoodsNum;
    }

    public Integer getExt1() {
        return ext1;
    }

    public void setExt1(Integer ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    @Override
    public String toString() {
        return "ShoppingCartInfo{" +
                "shoppingCartId=" + shoppingCartId +
                ", shoppingCartName='" + shoppingCartName + '\'' +
                ", shoppingCartNum=" + shoppingCartNum +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", goodsId=" + goodsId +
                ", userId=" + userId +
                ", goodsPrice=" + goodsPrice +
                ", maxGoodsNum=" + maxGoodsNum +
                ", ext1=" + ext1 +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                '}';
    }
}

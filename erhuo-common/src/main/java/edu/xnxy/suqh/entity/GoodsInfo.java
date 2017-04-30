package edu.xnxy.suqh.entity;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/20.
 */
public class GoodsInfo {

    /*
    * 商品ID
    * */
    private Integer goodsId;

    /*
    * 文件名称
    * */
    private String fileName;

    /*
    * 文件路径
    * */
    private String filePath;

    /*
    * 商品名称
    * */
    private String goodsName;

    /*
    *商品详情
    * */
    private String goodsDesc;

    /*
    * 交易地点
    * */
    private String tradLocation;

    /*
    * 商品价格
    * */
    private Integer goodsPrice;

    /*
    * 商品类型
    * */
    private String goodsType;

    /*
    * 联系方式
    * */
    private String phoneNum;

    /*
    * 商品数量
    * */
    private Integer goodsNum;

    /*
    * 用户ID
    * */
    private Integer userId;

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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getTradLocation() {
        return tradLocation;
    }

    public void setTradLocation(String tradLocation) {
        this.tradLocation = tradLocation;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "GoodsInfo{" +
                "goodsId=" + goodsId +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", tradLocation='" + tradLocation + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsType='" + goodsType + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                ", userId=" + userId +
                ", ext1=" + ext1 +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                '}';
    }
}

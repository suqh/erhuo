package edu.xnxy.suqh.service;

import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/20.
 */
public interface IGoodsService {
    /**
     * 添加商品
     */
    public void addGoods(GoodsInfo goodsInfo) throws Exception;

    /**
     * 删除商品
     */
    public void deleteGoods(GoodsInfo goodsInfo) throws Exception;

    /**
     * 修改商品信息
     */
    public void updateGoods(GoodsInfo goodsInfo) throws Exception;

    /**
     * 查询商品信息
     */
    public GoodsInfo getGoods(GoodsInfo goodsInfo) throws Exception;

    /**
     * 查询商品信息
     */
    public List<GoodsInfo> queryGoodes(GoodsInfo goodsInfo) throws Exception;

    /*
     * 根据userId查询商品信息
     * */
    public List<GoodsInfo> queryGoodsInfoByUserId(Integer userId) throws Exception;

   /**
    * 根据goodsId查询商品信息
    */
   public GoodsInfo queryGoodsInfoByGoodsId(Integer goodsId);

    /**
     * 根据输入的商品名称、选择的商品类型、商品的价格查询商品
     */
    public List<GoodsInfo> queryGoodsInfoByCondition(String goodsName,String goodsType,Integer minGoodsPrice,Integer maxGoodsPrice,Integer userId);
}

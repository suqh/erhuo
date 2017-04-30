package edu.xnxy.suqh.dao;

import edu.xnxy.suqh.entity.GoodsInfo;

import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/20.
 */
public interface IGoodsDao extends BaseDao<GoodsInfo>{

    /**
     *根据userId查询商品信息
     * @param userId
     * @return
     */
    public List<GoodsInfo> queryGoodsInfoByUserId(Integer userId);

    /**
     * 根据goodsId查询商品信息
     * @param goodsId
     * @return
     */
    public GoodsInfo queryGoodsInfoByGoodsId(Integer goodsId);

    /**
     * 查询多条商品信息
     * @param
     * @return
     */
    public List<GoodsInfo> query(GoodsInfo goodsInfo);

    /**
     * 根据输入的商品名称、选择的商品类型、商品的价格查询商品
     * @param
     * @return
     */
    public List<GoodsInfo>  queryGoodsInfoByCondition(String goodsName,String goodsType,Integer minGoodsPrice,Integer maxGoodsPrice,Integer userId);
}

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
     * 获取指定数量的推荐商品，但是不查询用户自己发布的和当前查看的商品
     *
     * @param goodsType 查询商品类型
     * @param goodsId   不查询的商品编号
     * @param userId    不查询的用户编号（当前登录用户）
     * @param count     查询数量
     * @return
     */
    public List<GoodsInfo> queryRecommendGoodsInfo(String goodsType, Integer goodsId, Integer userId, Integer count);

    /**
     * 根据输入的商品名称、选择的商品类型、商品的价格查询商品
     */
    public List<GoodsInfo> queryGoodsInfoByCondition(String goodsName, String goodsType, Integer minGoodsPrice, Integer maxGoodsPrice, Integer userId);

    /**
     * 查询跟当前商品是同一卖家的其他商品
     * @param goodsId 不查询的商品编号
     * @param userId 所展示商品的用户的编号
     * @param count 查询数量
     * @return
     */
    public List<GoodsInfo> queryRecommendGoodsInfo(Integer goodsId, Integer userId ,Integer count);
}

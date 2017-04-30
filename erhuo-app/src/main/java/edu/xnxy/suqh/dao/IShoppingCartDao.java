package edu.xnxy.suqh.dao;

import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.entity.ShoppingCartInfo;

import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/28.
 */
public interface IShoppingCartDao extends BaseDao<ShoppingCartInfo> {
    /**
     * 查询多条记录
     *
     * @param userId
     * @return
     */
    public List<ShoppingCartInfo> queryShoppingCartByUserId(Integer userId);

    /**
     * 根据goodsId查询购物车商品信息
     * @param goodsId
     * @return
     */
    public ShoppingCartInfo queryShoppingCartInfoByGoodsIdAndUserId(Integer goodsId,Integer userId);
}
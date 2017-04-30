package edu.xnxy.suqh.service;

import edu.xnxy.suqh.entity.ShoppingCartInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/28.
 */
public interface IShoppingCartService {

    /**
     * 新增一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    public void addShoppingCart(ShoppingCartInfo shoppingCartInfo) throws SQLException;

    /**
     * 根据用户id清理购物车信息
     *
     * @param userId 用户编号
     * @return
     */
    public void deleteShoppingCartByUserId(Integer userId) throws SQLException;

    /**
     * 删除一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    public void deleteShoppingCart(ShoppingCartInfo shoppingCartInfo) throws SQLException;

    /**
     * 修改一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    public void updateShoppingCartInfo(ShoppingCartInfo shoppingCartInfo) throws SQLException;

    /**
     * 查询一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    public ShoppingCartInfo get(ShoppingCartInfo shoppingCartInfo);

    /**
     * 查询多条记录
     *
     * @param userId
     * @return
     */
    public List<ShoppingCartInfo> queryShoppingCartByUserId(Integer userId);

    /**
     * 根据goodsId查询商品信息
     *
     * @param goodsId
     * @return
     */
    public ShoppingCartInfo queryShoppingCartInfoByGoodsIdAndUserId(Integer goodsId,Integer userId);
}

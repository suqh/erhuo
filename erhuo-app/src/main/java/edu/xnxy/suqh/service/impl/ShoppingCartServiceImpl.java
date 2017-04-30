package edu.xnxy.suqh.service.impl;

import edu.xnxy.suqh.dao.IShoppingCartDao;
import edu.xnxy.suqh.entity.ShoppingCartInfo;
import edu.xnxy.suqh.service.IShoppingCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/28.
 */
@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements IShoppingCartService{

    @Resource
    private IShoppingCartDao shoppingCartDao;

    /**
     * 新增一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    @Override
    public void addShoppingCart(ShoppingCartInfo shoppingCartInfo) throws SQLException {
        try {
            shoppingCartDao.save(shoppingCartInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    @Override
    public void deleteShoppingCart(ShoppingCartInfo shoppingCartInfo) throws SQLException {
        try {
            shoppingCartDao.delete(shoppingCartInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    @Override
    public void updateShoppingCartInfo(ShoppingCartInfo shoppingCartInfo) throws SQLException {
        try {
            shoppingCartDao.update(shoppingCartInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    @Override
    public ShoppingCartInfo get(ShoppingCartInfo shoppingCartInfo) {
        return null;
    }

    /**
     * 查询多条记录
     *
     * @param userId
     * @return
     */
    @Override
    public List<ShoppingCartInfo> queryShoppingCartByUserId(Integer userId) {
        List<ShoppingCartInfo> shoppingCartInfos = null;
        try {
            shoppingCartInfos = shoppingCartDao.queryShoppingCartByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoppingCartInfos;
    }

    /**
     * 根据goodsId查询商品信息
     *
     * @param goodsId
     * @return
     */
    @Override
    public ShoppingCartInfo queryShoppingCartInfoByGoodsIdAndUserId(Integer goodsId,Integer userId) {
        ShoppingCartInfo shoppingCartInfo = shoppingCartDao.queryShoppingCartInfoByGoodsIdAndUserId(goodsId,userId);
        return shoppingCartInfo;
    }
}

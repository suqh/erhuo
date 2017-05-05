package edu.xnxy.suqh.service.impl;

import edu.xnxy.suqh.dao.IGoodsDao;
import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.service.IGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 * Created by suqh on 2017/4/20.
 */
@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {

    @Resource
    private IGoodsDao goodsDao;
    /**
     * 添加商品
     *
     * @param goodsInfo
     */
    @Override
    public void addGoods(GoodsInfo goodsInfo) throws Exception {
        try {
            goodsDao.save(goodsInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除商品
     *
     * @param goodsInfo
     */
    @Override
    public void deleteGoods(GoodsInfo goodsInfo) throws Exception {
        try {
            goodsDao.delete(goodsInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改商品信息
     *
     * @param goodsInfo
     */
    @Override
    public void updateGoods(GoodsInfo goodsInfo) throws Exception {
        try {
            goodsDao.update(goodsInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询商品信息
     *
     * @param goodsInfo
     */
    @Override
    public GoodsInfo getGoods(GoodsInfo goodsInfo) throws Exception {
        GoodsInfo goodsInfo1 = null;
        try {
            goodsInfo1 = goodsDao.get(goodsInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsInfo1;
    }

    /**
     * 查询商品信息
     *
     * @param goodsInfo
     */
    @Override
    public List<GoodsInfo> queryGoodes(GoodsInfo goodsInfo) throws Exception {
        List<GoodsInfo> goodsInfoList = goodsDao.query(goodsInfo);
        return goodsInfoList;
    }

    /**
     *根据userId查询商品信息
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<GoodsInfo> queryGoodsInfoByUserId(Integer userId) throws Exception {
        List<GoodsInfo> goodsInfoList = null;
        try {
            goodsInfoList = goodsDao.queryGoodsInfoByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsInfoList;
    }

    /**
     * 根据goodsId查询商品信息
     *
     * @param goodsId
     */
    @Override
    public GoodsInfo queryGoodsInfoByGoodsId(Integer goodsId) {
        GoodsInfo goodsInfo = goodsDao.queryGoodsInfoByGoodsId(goodsId);
        return goodsInfo;
    }

    /**
     * 获取指定数量的推荐商品，但是不查询用户自己发布的和当前查看的商品
     *
     * @param goodsType 查询商品类型
     * @param goodsId   不查询的商品编号
     * @param userId    不查询的用户编号（当前登录用户）
     * @param count     查询数量
     * @return
     */
    @Override
    public List<GoodsInfo> queryRecommendGoodsInfo(String goodsType, Integer goodsId, Integer userId, Integer count) {
        List<GoodsInfo> recommendList = null;
        try{
            recommendList = goodsDao.queryRecommendGoodsInfo(goodsType,goodsId,userId,count);
        }catch (Exception e){
            e.printStackTrace();
        }
        return recommendList;
    }


    /**
     * 根据输入的商品名称、选择的商品类型、商品的价格查询商品
     *
     * @param goodsName
     * @param goodsType
     * @param minGoodsPrice
     * @param maxGoodsPrice
     */
    @Override
    public List<GoodsInfo> queryGoodsInfoByCondition(String goodsName,String goodsType,Integer minGoodsPrice,Integer maxGoodsPrice,Integer userId) {
        List<GoodsInfo> goodsInfoList = null;
        goodsInfoList = goodsDao.queryGoodsInfoByCondition(goodsName,goodsType,minGoodsPrice,maxGoodsPrice,userId);
        return goodsInfoList;
    }

    /**
     * 查询跟当前商品是同一卖家的其他商品
     *
     * @param goodsId 不查询的商品编号
     * @param userId  所展示商品的用户的编号
     * @param count   查询数量
     * @return
     */
    @Override
    public List<GoodsInfo> queryRecommendGoodsInfo(Integer goodsId, Integer userId, Integer count) {
        List<GoodsInfo> recommendList = null;
        try{
            recommendList = goodsDao.queryRecommendGoodsInfo(goodsId,userId,count);
        }catch (Exception e){
            e.printStackTrace();
        }
        return recommendList;
    }
}

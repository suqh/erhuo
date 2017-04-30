package edu.xnxy.suqh.web.listener;

import edu.xnxy.suqh.entity.StaticData;
import edu.xnxy.suqh.service.IStaticService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/27.
 */
public class SessionListener implements HttpSessionListener {

    @Resource
    private IStaticService staticService;


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        try {
            //获取下拉列表静态数据
            List<StaticData> goodsTypeList = staticService.staticDataList(2, null);
            HttpSession session = httpSessionEvent.getSession();
            session.setAttribute("goodsTypeList", goodsTypeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}

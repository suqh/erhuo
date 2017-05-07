package edu.xnxy.suqh.web.listener;

import edu.xnxy.suqh.entity.StaticData;
import edu.xnxy.suqh.entity.UserAccess;
import edu.xnxy.suqh.service.IStaticService;
import edu.xnxy.suqh.service.IUserAccessService;
import edu.xnxy.suqh.util.IPUtil;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;
import java.util.List;

/**
 * description:Session监听
 *
 * @author suqh
 *         Created by suqh on 2017/4/27.
 */
public class SessionListener implements HttpSessionListener {

    private static Logger log = Logger.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        try {
            //获取staticService bean对象,注意SessionListener监听器中获取bean对象不能使用注解的方式，只能通过WebApplicationContext中获取
            WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(httpSessionEvent.getSession().getServletContext());
            IUserAccessService userAccessService  = (IUserAccessService) applicationContext.getBean("userAccessService");
            //保存数据
            UserAccess userAccess = new UserAccess();
            userAccess.setAccessDate(new Date());
            userAccessService.insert(userAccess);
        } catch (Exception e) {
            log.error("sessionCreated出错",e);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}

package edu.xnxy.suqh.web.listener;

import edu.xnxy.suqh.entity.StaticData;
import edu.xnxy.suqh.service.IStaticService;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Description:监听ServletContextListener
 *
 * Created by caojx on 17-5-6.
 */
public class ApplicationContextListener implements ServletContextListener {

    private static Logger log = Logger.getLogger(ApplicationContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            //获取staticService bean对象,注意SessionListener监听器中获取bean对象不能使用注解的方式，只能通过WebApplicationContext中获取
            WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
            IStaticService staticService = (IStaticService) applicationContext.getBean("staticService");
            //获取下拉列表静态数据
            List<StaticData> goodsTypeList = staticService.staticDataList(2, null);
            ServletContext servletContext = servletContextEvent.getServletContext();
            servletContext.setAttribute("goodsTypeList", goodsTypeList);
        } catch (Exception e) {
            log.error("contextInitialized出错",e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

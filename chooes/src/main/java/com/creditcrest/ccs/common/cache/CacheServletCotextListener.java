package com.creditcrest.ccs.common.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**启动机制加载缓存
 * Created by 柏世民 on 2017/7/4.
 */
public class CacheServletCotextListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(CacheServletCotextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("哟嚯,我启动啦 : >> ");
        //加载自动注入Autowire

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("哟嚯,我销毁啦 : >> ");
    }
}

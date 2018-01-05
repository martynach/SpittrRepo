package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Under the covers, this class creates both: DispatcherServlet and ContextLoaderListener
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * @return - the @Configuration classes that will be used
     * to configure application context created by ContextLoaderListener
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }


    /**
     * @return - the @Configuration classes will be used
     * to configure DispatcherServlet's application context
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }


    /**
     * @return - Identifies one or more paths that DispatcherServlet will be mapped to
     */
    @Override
    protected String[] getServletMappings() {
        //return new String[]{"/spittr", "/spittr/spittles", "/spittr/spitter/register"};
        return new String[]{"/"};

    }


}

/**
 * 
 */
package alexkholmov.organizer.services;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author SASH
 *
 */
public class AppContext implements ApplicationContextAware {

    private static ApplicationContext context;
    
    /**
     * @return the context
     */
    public static ApplicationContext getContext() {
        return context;
    }


    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        // TODO Auto-generated method stub
        context = arg0;
    }

}

package ua.com.goit.gojava7.kickstarter;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

//    private Logger log = Logger.getLogger(getClass());

    @After("execution(* ua.com.goit.gojava7.kickstarter..*.*(..))")
    public void log(JoinPoint point) {
//        log.info(point.getSignature().getName() + " called...");
        System.out.println(point.getSignature().getName() + " called...");
    }
}
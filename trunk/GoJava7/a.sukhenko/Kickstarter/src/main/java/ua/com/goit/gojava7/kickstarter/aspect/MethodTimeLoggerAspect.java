package ua.com.goit.gojava7.kickstarter.aspect;

import javax.naming.AuthenticationException;
import javax.xml.bind.ValidationException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

//@Aspect
public class MethodTimeLoggerAspect{
    private static final Logger log = LogManager.getLogger(MethodTimeLoggerAspect.class);
    
   // @Pointcut("@within(org.springframework.stereotype.Repository)")
    public void service(){
    }
    
    @Order(200)
    //@Around("service()") // //
    @Around("execution(* ua.com.goit.gojava7.kickstarter.dao.db.CategoryDatabaseDao.getAll())")
    public Object traceService(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        
       String methodname = joinPoint.getSignature().getName();
        try{
            log.log(Level.TRACE, "Start of method: " + methodname); 
            joinPoint.proceed();
            log.trace("End of method: " + methodname);
        }catch (ValidationException e) {
            // if it ValidationException we don't wont to log it
            throw e;
        } catch (AuthenticationException e) {
            // it's spring authentication exception, let spring handle it
            throw e;
        } catch (Exception e) {
            log.trace("Exiting with throwing exception {}", e.getMessage(), e);
            throw e;
        } finally {
            // execution end time
            final long end = System.currentTimeMillis();
            // print delta - execution time in milliseconds
            log.trace("Method execution time: " + (end - start) + " method: " + methodname);
        }
        
        return joinPoint;
        
        
    }
}

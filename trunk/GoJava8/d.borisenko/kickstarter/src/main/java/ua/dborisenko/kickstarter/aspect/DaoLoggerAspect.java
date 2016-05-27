package ua.dborisenko.kickstarter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Aspect
@Order(value = 1)
public class DaoLoggerAspect {

    private static final Logger log = LoggerFactory.getLogger(DaoLoggerAspect.class);

    @Pointcut("within(ua.dborisenko.kickstarter.dao.*)")
    public void dao() {
    }

    @Around("dao()")
    public Object logDao(ProceedingJoinPoint joinPoint) throws Throwable {
        log.trace("Called {}.", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        log.trace("Method {} returned {}.", joinPoint.getSignature(), result);
        return result;
    }
}

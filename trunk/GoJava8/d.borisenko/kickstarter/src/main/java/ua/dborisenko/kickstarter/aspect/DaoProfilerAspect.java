package ua.dborisenko.kickstarter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Aspect
@Order(value = 0)
public class DaoProfilerAspect {

    private static final Logger log = LoggerFactory.getLogger(DaoProfilerAspect.class);

    @Pointcut("within(ua.dborisenko.kickstarter.dao.*)")
    public void dao() {
    }

    @Around("dao()")
    public Object profileDao(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTimeMs = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        log.trace("Method {} finished after {} ms.", joinPoint.getSignature(),
                System.currentTimeMillis() - startTimeMs);
        return result;
    }
}

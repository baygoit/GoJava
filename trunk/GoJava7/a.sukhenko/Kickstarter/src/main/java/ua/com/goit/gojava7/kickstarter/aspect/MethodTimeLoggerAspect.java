package ua.com.goit.gojava7.kickstarter.aspect;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodTimeLoggerAspect{
    private static final org.apache.logging.log4j.Logger log2 = LogManager.getLogger(MethodTimeLoggerAspect.class);
    @Around("calculateTime()")
    public Object calculateTime(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();

        long elapsedTime = System.currentTimeMillis() - start;
        log2.info("Execution time:" + elapsedTime + " methodName: " + methodName);
        return output;
    }

    @Pointcut("@within(org.springframework.stereotype.Repository)")
    private void calculateTime() {
    }
}

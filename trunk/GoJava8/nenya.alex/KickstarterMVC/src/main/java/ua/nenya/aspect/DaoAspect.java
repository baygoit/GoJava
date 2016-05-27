package ua.nenya.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

@Aspect
public class DaoAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(DaoAspect.class);
	
	@Pointcut("execution(* ua.nenya.dao..*.*(..))")
	private void businessDao() {}
	
	@Around("execution(* ua.nenya.dao..*.*(..))")
	  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
	    Object result = joinPoint.proceed();
	    stopWatch.stop();
	    logger.info("method " + joinPoint.getSignature().getName()+" lasts "+ stopWatch.getTotalTimeMillis() +" ms");
		return result;
	  }
	
	@Before("execution(* ua.nenya.dao..*.*(..))")
	  public void before(JoinPoint joinPoint){
		logger.info("method " + joinPoint.getSignature().getName()+" with arguments: " + Arrays.toString(joinPoint.getArgs()));
	  }
	
	@AfterReturning(value = "execution(* ua.nenya.dao..*.*(..))", returning = "returnValue")
	  public void afterReturning(JoinPoint joinPoint, Object returnValue){
		logger.info("result is "+returnValue+" of the method " + joinPoint.getSignature().getName());
	  }

}

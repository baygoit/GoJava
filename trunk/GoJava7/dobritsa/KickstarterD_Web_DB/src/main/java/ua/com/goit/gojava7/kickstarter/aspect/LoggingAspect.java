package ua.com.goit.gojava7.kickstarter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);	
	
	@Around("within( ua.com.goit.gojava7.kickstarter.dao..*)")
	public Object time(ProceedingJoinPoint pjp) throws Throwable {	
		String methodName = pjp.getSignature().getName();
		String className = pjp.getSignature().getDeclaringType().getSimpleName();
		long start = System.currentTimeMillis();	
		log.trace("{}.{}() is going to be called", className, methodName);	
		Object output = pjp.proceed();
		log.trace("{}.{}() execution completed", className, methodName);
		long elapsedTime = System.currentTimeMillis() - start;
		log.trace("{}.{}() execution time: {} milliseconds", className, methodName, elapsedTime);
		return output;		
	}	
}

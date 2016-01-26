package ua.com.goit.gojava7.kickstarter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value = 200)
public class LoggerAspect {
	private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);

	@Around("execution(* ua.com.goit.gojava7.kickstarter..*.*(..))")
	public Object calculateMethodExecutionTime(ProceedingJoinPoint jointPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object output = jointPoint.proceed();
		long elapsedTime = System.currentTimeMillis() - start;

		log.info("{} : {}", "Method name", jointPoint.getSignature());
		log.info("{} : {} {}", "Method execution time", elapsedTime, "milliseconds.");

		return output;
	}

}

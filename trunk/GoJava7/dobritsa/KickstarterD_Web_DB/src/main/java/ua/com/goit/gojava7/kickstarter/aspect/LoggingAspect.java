package ua.com.goit.gojava7.kickstarter.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);	 
	
	@Pointcut("execution(* ua.com.goit.gojava7.kickstarter.dao.*.*(..))")
   public void doSomething() {
    }
	
	//@Pointcut("within( ua.com.goit.gojava7.kickstarter.dao..*)")
    //public void time() {
    //}
	
 
   //@Before(value = "doSomething()", argNames = "joinPoint")
   // public void beforeCall(JoinPoint joinPoint) {
	//   log.trace("Method Name :" + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
   // }
	
   @Before(value = "doSomething()", argNames = "joinPoint")
   public void beforeCall(JoinPoint joinPoint) {
   	
	   log.trace("Method Name :" + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
   }
	
	
	//@Before("within( ua.com.goit.gojava7.kickstarter.dao..*)")
	// public void logAround(JoinPoint joinPoint) {

	//		System.out.println("logAround() is running!");
			//System.out.println("Around before is running!");
			//System.out.println("Around after is running!");
	//	}
	
	
	
	@Around("within( ua.com.goit.gojava7.kickstarter.dao..*)")
	public Object time(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		log.trace("Going to call the method.");	
		Object output = pjp.proceed();
		log.trace("Method execution completed.");
		long elapsedTime = System.currentTimeMillis() - start;
		log.trace("Method execution time: {} milliseconds.", elapsedTime);
		return output;		
	}
}

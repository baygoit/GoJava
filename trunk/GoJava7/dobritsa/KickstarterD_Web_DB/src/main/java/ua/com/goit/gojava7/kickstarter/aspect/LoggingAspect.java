package ua.com.goit.gojava7.kickstarter.aspect;

import java.sql.ResultSet;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value = 200)
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	
	@Pointcut("execution(* ua.com.goit.gojava7.kickstarter.dao.QuoteDbDao.*(*));")
	private void timePoint5() {}	
	
	@Around("timePoint5()")
	public Object time5(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("------------------execution(* ua.com.goit.gojava7.kickstarter.dao.QuoteDbDao.*(*))");
		Object output = pjp.proceed();
		return output;
	}
	
	
	
	
	@Pointcut("execution(* ua.com.goit.gojava7.kickstarter.dao.QuoteDbDao.*(*));")
	private void timePoint4() {}	
	
	@Around("timePoint4()")
	public Object time4(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("------------------execution(* ua.com.goit.gojava7.kickstarter.dao.QuoteDbDao.*(*))");
		Object output = pjp.proceed();
		return output;
	}
	
	@Pointcut("within( ua.com.goit.gojava7.kickstarter..*)")
	private void timePoint3() {}
	
	@Around("timePoint3()")
	public Object time3(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("------------------within( ua.com.goit.gojava7.kickstarter..*)");
		Object output = pjp.proceed();
		return output;
	}
	
	
	@Pointcut("within(@(@org.springframework.stereotype.Component *) *)")
	private void timePoint2() {}
	
	@Around("timePoint2()")
	public Object time2(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("------------------within(@(@org.springframework.stereotype.Component *) *)");
		Object output = pjp.proceed();
		return output;
	}
	
	@Pointcut("within( ua.com.goit.gojava7.kickstarter.dao..*)")
	private void timePoint0() {}
	
	@Around("timePoint0()")
	public Object time0(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("------------------within( ua.com.goit.gojava7.kickstarter.dao..*)");
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

	
	@Before("within( ua.com.goit.gojava7.kickstarter.dao..*)")
	public void logBefore(JoinPoint joinPoint) {
		Object[] signatureArgs = joinPoint.getArgs();
		System.out.println("logBefore");

		//if(joinPoint.getArgs() instanceof ResultSet) {
		//	System.out.println("true");
		//}
		
		for (Object signatureArg : signatureArgs) {
			System.out.println("Arg: " + signatureArg);
			
			
			/*if(signatureArg instanceof ResultSet) {
				System.out.println("true");
			}			
			if (signatureArgs.toString().contains("jdbc")) {
				int index = 0;
				index = signatureArgs.toString().indexOf(": ");
				System.out.println(index);
				String query = "query";
				query = signatureArgs.toString().substring(index);
				System.out.println(query);
			}*/
			
		}

	}
}

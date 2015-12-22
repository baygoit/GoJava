package ua.com.goit.gojava7.kickstarter.aspect;

import javax.naming.AuthenticationException;
import javax.xml.bind.ValidationException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Aspect
public class TraceLoggerAspect {

	private static final Logger log = LoggerFactory.getLogger(TraceLoggerAspect.class);

	@Pointcut("@within(org.springframework.stereotype.Service) || @within(org.springframework.stereotype.Repository)")
	public void service() {
	}

	@Order(200)
	@Around("service()")
	public Object traceService(ProceedingJoinPoint joinPoint) throws Throwable {
		// execution start time
		final long start = System.currentTimeMillis();
		// fully qualified method name
		Signature signature = joinPoint.getSignature();
		Object target = joinPoint.getTarget();
		Object this1 = joinPoint.getThis();

		try {
			log.trace("Entering {} target = {} this = {}", signature, target, this1);
			// store result into tmp variable
			final Object result = joinPoint.proceed();
			// dump the result
			log.trace("Exiting {}  with result {}", signature, result);
			// return the result
			return result;
		} catch (ValidationException e) {
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
			log.trace("{}  miliseconds execution time for  {} target = {} this = {}", (end - start), signature, target, this1);
		}
	}
}

package ua.com.goit.gojava7.kickstarter.aspect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value = 200)
public class LoggingAspect {
	
	@Autowired
	protected BasicDataSource basicDataSource;

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("within( ua.com.goit.gojava7.kickstarter.dao.DbManager)")
	public void toDbQuery(JoinPoint joinPoint) {
		Object[] signatureArgs = joinPoint.getArgs();
		log.trace("<void> toDbQuery({})...");

		for (Object signatureArg : signatureArgs) {			
			if (signatureArg instanceof String) {
				String query = signatureArg.toString().toLowerCase();
				addQuery(query);
			}
		}
	}
	
	public void addQuery(String text) {		
		String query = "insert into query (text) VALUES (\"" + text + "\") on dublicate key update text=\"" + text + "\";";		
		log.trace("<void> addQuery({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {		
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * @Pointcut("execution(public * *(..))") private void timePoint5() {}
	 * 
	 * @Around("timePoint5()") public Object time5(ProceedingJoinPoint pjp)
	 * throws Throwable { System.out.println(
	 * "------------------execution(public * *(..))"); String methodName =
	 * pjp.getSignature().getName(); String className =
	 * pjp.getSignature().getDeclaringType().getSimpleName(); long start =
	 * System.currentTimeMillis(); log.trace("{}.{}() is going to be called",
	 * className, methodName);
	 * 
	 * Object output = pjp.proceed(); log.trace("{}.{}() execution completed",
	 * className, methodName);
	 * 
	 * long elapsedTime = System.currentTimeMillis() - start; log.trace(
	 * "{}.{}() execution time: {} milliseconds", className, methodName,
	 * elapsedTime); return output; }
	 */

	/*
	 * @Pointcut(
	 * "execution(* ua.com.goit.gojava7.kickstarter.dao.QuoteDbDao.*(*));")
	 * private void timePoint4() {}
	 * 
	 * @Around("timePoint4()") public Object time4(ProceedingJoinPoint pjp)
	 * throws Throwable { System.out.println(
	 * "------------------execution(* ua.com.goit.gojava7.kickstarter.dao.QuoteDbDao.*(*))"
	 * ); Object output = pjp.proceed(); return output; }
	 */

	/*
	 * @Pointcut("within( ua.com.goit.gojava7.kickstarter..*)") private void
	 * timePoint3() {}
	 * 
	 * @Around("timePoint3()") public Object time3(ProceedingJoinPoint pjp)
	 * throws Throwable { System.out.println(
	 * "------------------within( ua.com.goit.gojava7.kickstarter..*)"); Object
	 * output = pjp.proceed(); return output; }
	 */

	/*
	 * @Pointcut("within(@(@org.springframework.stereotype.Component *) *)")
	 * private void timePoint2() {}
	 * 
	 * @Around("timePoint2()") public Object time2(ProceedingJoinPoint pjp)
	 * throws Throwable { System.out.println(
	 * "------------------within(@(@org.springframework.stereotype.Component *) *)"
	 * ); Object output = pjp.proceed(); return output; }
	 */

	/*
	@Pointcut("within( ua.com.goit.gojava7.kickstarter.dao..*)")
	private void timePoint0() {
	}

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
	}*/


}

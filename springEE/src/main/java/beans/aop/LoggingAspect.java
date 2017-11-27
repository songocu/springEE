package beans.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Around(value = "execution(* controller.rest.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("REST controller called");
		Object result = pjp.proceed();
		System.out.println("REST controller call success");
		return result;
	}
}
package spring5_aop_study.aspect;


import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect {

	@Pointcut("execution(public * spring5_aop_study.aop..*(..))")
	// @Pointcut("execution(접근제어자 반환형 패키지를포함한클래스경로 메소드 파라미터)")
	//						 public		*		 spring5_aop_study.aop    *		(..)<< parameter는 몇 개가 오든 신경쓰지 않겠다는 의미
	private void publicTarget() {}
	
	
	@Around("publicTarget()") // publicTarget()은 핵심기능을 의미 << 이 부분을 Around해서 이거 해라
						// ProceedingJoinPoint << interface임
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s (%s) 실행 시간: %d ns%n", joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(), Arrays.deepToString(joinPoint.getArgs()), (finish - start));
		}
	}
	
}

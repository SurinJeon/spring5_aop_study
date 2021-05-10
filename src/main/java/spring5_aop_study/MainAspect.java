package spring5_aop_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring5_aop_study.aop.Calculator;
import spring5_aop_study.aop.RecCalculator;
import spring5_aop_study.config.AppCtx;

public class MainAspect {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);){ 
			// AnnotationConfigApplicationContext << @Configuration annotation이 붙은 클래스를 설정 정보로 사용
			Calculator calculator = ctx.getBean("calculator", Calculator.class); // getBean() << ApplicationContext가 관리하는 object를 요청하는 method
//			RecCalculator calculator = ctx.getBean("calculator", RecCalculator.class); // getBean() << ApplicationContext가 관리하는 object를 요청하는 method
			// 그냥 ctx.getBean("recCal")로 하면 Object로 반환하기 때문에, 뒤에 형변환을 위해서 리턴타입을 두번째 pararmeter에 적어줌
			
			long fiveFact = calculator.factorial(5);
			System.out.printf("calculator.factorial(5) = %d%n", fiveFact);
			System.out.println(calculator.getClass().getName());
			
//			Calculator impeCal = ctx.getBean("impeCal", Calculator.class);
//			
//			fiveFact = recCal.factorial(5);
//			System.out.printf("impeCal.factorial(5) = %d%n", fiveFact);
//			System.out.println(impeCal.getClass().getName());
		}
	}
}

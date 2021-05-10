package spring5_aop_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring5_aop_study.aop.Calculator;
import spring5_aop_study.config.AppCtxWithCache;

public class MainAspectWithCache {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithCache.class);) {
			Calculator cal = ctx.getBean("calculator", Calculator.class);

			cal.factorial(7);
			cal.factorial(7);
			cal.factorial(5);
			cal.factorial(5);
		}
	}
}

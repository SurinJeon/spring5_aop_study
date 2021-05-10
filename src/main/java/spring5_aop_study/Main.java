package spring5_aop_study;

import spring5_aop_study.aop.Calculator;
import spring5_aop_study.aop.ExeTimeCalculator;
import spring5_aop_study.aop.ImpeCalculator;
import spring5_aop_study.aop.RecCalculator;

public class Main {

	public static void main(String[] args) {
//		test01();
		
		int num = 5;
		long result = 0;
		
		ExeTimeCalculator impeCalculator = new ExeTimeCalculator(new ImpeCalculator());
		result = impeCalculator.factorial(num);
		System.out.printf("%d! = %d%n", num, result);
		
		
		ExeTimeCalculator recCalculator = new ExeTimeCalculator(new RecCalculator());
		result = recCalculator.factorial(num);
		System.out.printf("%d! = %d%n", num, result);
	}

	private static void test01() {
		int num = 5;
		long res = -1;
		long start = 0;
		long end = 0;
		
		Calculator impeCal = new ImpeCalculator();
		
//		start = System.currentTimeMillis();
		res = impeCal.factorial(num);
//		end =  System.currentTimeMillis();
		
//		System.out.printf("ImpeCalculator.factorial(%d) 실행시간 = %d %n", num, (end - start));
		System.out.printf("%d! = %d%n", num, res);
		
		Calculator reCal = new RecCalculator();
		
//		start = System.currentTimeMillis();
		res = reCal.factorial(num);
//		end =  System.currentTimeMillis();
		
//		System.out.printf("RecCalculator.factorial(%d) 실행시간 = %d %n", num, (end - start));
		System.out.printf("%d! = %d%n", num, res);
	}
}

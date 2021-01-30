package com.koreait.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
		
		// bean 등록 하는 순간 객체는 무조건 생성
		
		LgTV lTv = (LgTV)ctx.getBean("lg");
		lTv.volumeUp();
		System.out.println("lTv : " + lTv);
		
		SamsungTV sTv = (SamsungTV)ctx.getBean("samsung");
		sTv.volumeUp();
		sTv.volumeUp();
		System.out.println("sTv : " + sTv);
	}

}

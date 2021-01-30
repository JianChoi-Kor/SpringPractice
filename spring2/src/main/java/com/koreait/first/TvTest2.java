package com.koreait.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application2.xml");
		
		Tv tv = ctx.getBean(LgTV.class);
		tv.volumeUp();
		tv.volumeUp();
		System.out.println("tv : " + tv);

	}

}

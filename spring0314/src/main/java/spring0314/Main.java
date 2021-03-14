package spring0314;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		
//		TransportationWalk transportaionWalk = new TransportationWalk();
//		transportaionWalk.move();
		
		// applicationContext에서 메모리 로딩한 Transportation 객체를 사용하기 위해서
		// springContainer에 접근을 해야한다.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TransportationWalk taransportationWalk = ctx.getBean("tWalk", TransportationWalk.class);
		taransportationWalk.move();
		
		ctx.close();
	}
	
}

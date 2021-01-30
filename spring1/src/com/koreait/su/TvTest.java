package com.koreait.su;

public class TvTest {

	public static void main(String[] args) {
		
		Tv tv = Factory.makeTv(args[0]);
		tv.setSpeaker(Factory.makeSpeaker(args[1]));
		
		for(int i=0; i<100; i++) {
			tv.volumeUp();
		}
		System.out.println(tv);
		System.out.println("-----------------");
		for(int i=0; i<5; i++) {
			tv.voluemDown();
		}
		System.out.println(tv);
	}	
}

package com.koreait.first;

public class SamsungTV extends Tv {
	public SamsungTV() {
		super(20, 10);
		System.out.println("SamsungTV 생성");
	}
	
	public SamsungTV(int maxChannel, int maxVolume, Speaker speaker) {
		super(maxChannel, maxVolume, speaker);
	}
	
}

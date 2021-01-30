package com.koreait.su;

public class BossSpeaker implements Speaker{
	private int maxSoundPower;
	private int currentSoundPower;
	
	public BossSpeaker()  {
		maxSoundPower = 10;
		System.out.println("-- BossSpeaker 생성 --");
	}
	
	public void soundPowerUp() {
		if(currentSoundPower < maxSoundPower) {
			currentSoundPower++;
		}
	}
	
	public void soundPowerDown() {
		if(currentSoundPower > 0) {
			currentSoundPower--;
		}
	}
}

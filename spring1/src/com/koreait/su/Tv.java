package com.koreait.su;

public abstract class Tv {
	private int maxChannel;
	private int maxVolume;
	
	private int currentChannel;
	private int currentVolume;
	
	private Speaker speaker;
	
	// 생성자와 메서드 다른점
	// 메서드는 기본적으로 리턴타입이 있어야한다. 
	// 멤버필드 이름, 메서드 이름은 대문자로 시작하면 안된다.
	// 클래스명과 이름이 똑같다. 리턴타입이 없다. (=생성자)
	// 보통 생성자 앞에는 public	이 붙어 있다.
	
	public Tv(int maxChannel, int maxVolume) {
		this.maxChannel = maxChannel;
		this.maxVolume = maxVolume;
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void volumeUp() {
		if(currentVolume < maxVolume) {
			currentVolume++;
			speaker.soundPowerUp();
		}
	}
	
	public void voluemDown() {
		if(currentVolume > 0) {
			currentVolume--;
			speaker.soundPowerDown();
		}
	}
	
	@Override
	public String toString() {
		return String.format("volume: %d", currentVolume);
	}
	
	
	
}

package com.koreait.first;

import org.springframework.stereotype.Component;

@Component
public class LgTV extends Tv{
	public LgTV() {
		super(10, 20);
		System.out.println("LGTV 생성");
	}
}

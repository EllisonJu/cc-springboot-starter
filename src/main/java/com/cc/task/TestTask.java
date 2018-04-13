package com.cc.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {
	
	private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");
	
	//定义每过三秒执行一次
//	@Scheduled(fixedDelay=3000)
	@Scheduled(cron = "30-36 52-53 * * * ? ")
	public void reportCurrentTime(){
		System.err.println("现在时间:"+dataFormat.format(new Date()));
	}

}

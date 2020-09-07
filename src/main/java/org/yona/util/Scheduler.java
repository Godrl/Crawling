package org.yona.util;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.yona.crawl.CrawlingService;

@Component
public class Scheduler {

	private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);
	
	@Inject
	private CrawlingService service;
		
		@Scheduled(cron = "0 0 10 * * *") // 매일 오전10시에 자동적으로 크롤링을 함 
		public void autoUpdate() {
			logger.info("===== Crawling Auto Update =====");
			try {
				service.crawl();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}

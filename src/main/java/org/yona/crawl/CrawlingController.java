package org.yona.crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CrawlingController {

	private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);
	
	@Inject
	private CrawlingService service;
	
	@RequestMapping(value = "/crawl", method = RequestMethod.GET)
	public void crawl(Model model) {
		logger.info("=====crawl=====");
		
		List<CrawlingVO> list = null;
		
		try {
			list = service.crawl();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("newsList", list);
		
		
	}
}

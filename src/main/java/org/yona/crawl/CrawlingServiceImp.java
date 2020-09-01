package org.yona.crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CrawlingServiceImp implements CrawlingService{

	private static final Logger logger = LoggerFactory.getLogger(CrawlingServiceImp.class);
	private static String url ="https://zdnet.co.kr/news/?lstcode=0000&page=1"; 
	
	@SuppressWarnings("null")
	@Override
	public List<CrawlingVO> crawl() throws IOException {

		List<CrawlingVO> list = new ArrayList<CrawlingVO>();
		
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements newsList= doc.select("div.left_cont");
		String title = newsList.select("h3").text();
		String body = newsList.select("p").text();
		
		logger.info("title = "+title);
		logger.info("body = "+body);
		
//		div.newPost = div.assetText
		for(Element element : newsList.select("div.newsPost")) {
			
			CrawlingVO cvo = new CrawlingVO();
			
			cvo.setTitle(element.select("h3").text());
			cvo.setBody(element.select("p").text());
			
			list.add(cvo);
		}
	
		return list;
		
	}

}

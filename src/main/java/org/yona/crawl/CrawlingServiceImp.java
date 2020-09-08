package org.yona.crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

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
	
	@Inject
	private CrawlingDAO dao;
	
	@Override
	public List<CrawlingVO> crawl() throws IOException {

		List<CrawlingVO> list = new ArrayList<CrawlingVO>();
		
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		doc.select("[href]") : href 속성을 가진 요소들을 선택합니다.
				
//		<section class = "news_box"> 태그 안에 내용들을 모두 가져온다.		
		Elements newsList= doc.select("section.news_box");
						
//		<dic class = "newsPost">태그 안에 내용들을 element에 담는다.
		for(Element element : newsList.select("div.newsPost")) {
						
			CrawlingVO cvo = new CrawlingVO();
			
//			뉴스 제목,뉴스 내용,링크,이미지,날짜를 가져와서 담는다.
			cvo.setTitle(element.select("h3").text()); //title
			cvo.setContent(element.select("a").select("p").text()); //content
			cvo.setLink(element.getElementsByAttribute("href").attr("href")); //link
			cvo.setImg(element.getElementsByAttribute("data-src").attr("data-src")); //image
			cvo.setDate(element.select("span").text()); // date
			
//			최신기사만 DB에 저장하고 이미 저장되어 있는 기사는 저장하지 않는다.
			if(cvo.getDate().compareTo(hotNews()) > 0 ) dao.insertData(cvo);
			
			list.add(cvo);
		}
		
		return list;
	}

	@Override
	public String hotNews() {
		return dao.hotNews();
	}

}

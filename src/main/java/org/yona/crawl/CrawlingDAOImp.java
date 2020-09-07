package org.yona.crawl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CrawlingDAOImp implements CrawlingDAO{

	@Inject
	private SqlSession session;
	
	private static final String namsepace = "crawl"; 
	
	@Override
	public void insertData(CrawlingVO cvo) {
		session.insert(namsepace+".rgstData",cvo);
	}

}

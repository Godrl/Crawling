package org.yona.crawl;

import java.io.IOException;
import java.util.List;

public interface CrawlingService {

	public List<CrawlingVO> crawl()throws IOException;
	
}

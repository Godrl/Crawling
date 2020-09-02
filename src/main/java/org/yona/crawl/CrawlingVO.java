package org.yona.crawl;

public class CrawlingVO {

	private String title;
	private String body;
	private String link;
		
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "CrawlingVO [title=" + title + ", body=" + body + "]";
	}
}

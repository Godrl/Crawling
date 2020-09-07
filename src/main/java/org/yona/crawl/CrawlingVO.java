package org.yona.crawl;

import java.util.Date;

public class CrawlingVO {

	private String title;
	private String content;
	private String link;
	private String img;
		
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "CrawlingVO [title=" + title + ", content=" + content + ", link=" + link + ", img=" + img + "]";
	}
	
}

package com.daolayer;

public class ArticlesDisplayBean {

	private String article_id;
	private String article_name;
	private String Store_name;
	private String article_color;
	
	
	public   ArticlesDisplayBean(String article_id,String article_name,String Store_name, String article_color ) {
		this.article_id=article_id;
		this.article_name=article_name;
		this.Store_name=Store_name;
		this.article_color=article_color;
		
	}
	
	public  String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getArticle_name() {
		return article_name;
	}
	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}
	public String getStore_name() {
		return Store_name;
	}
	public void setStore_name(String store_name) {
		Store_name = store_name;
	}
	public String getArticle_color() {
		return article_color;
	}
	public void setArticle_color(String article_color) {
		this.article_color = article_color;
	}
	
}

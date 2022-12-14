package com.linkedin.jsf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.linkedin.CatalogItem;
import com.linkedin.CatalogLocal;
import com.linkedin.ItemManager;

@Named
@ConversationScoped
public class CatalogItemDetailBean implements Serializable {
	
	private long itemId;

	private CatalogItem item;

	@Inject
	private Conversation conversation;
	
	@Inject
	private CatalogLocal catalogBean;
	
	private ItemManager manager = new ItemManager();

	public void fetchItem() {
		this.item = this.catalogBean.findItem(this.itemId);
	}
	
	public void addManager() {

	}
	
	@PostConstruct
	public void init() {
		this.conversation.begin();
	}
	
	@PreDestroy
	public void destroy() {
		conversation.end();
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public CatalogItem getItem() {
		return item;
	}

	public void setItem(CatalogItem item) {
		this.item = item;
	}

	public ItemManager getManager() {
		return manager;
	}

	public void setManager(ItemManager manager) {
		this.manager = manager;
	}

	
}


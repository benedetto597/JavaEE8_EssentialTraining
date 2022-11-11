package com.linkedin.jsf;

import java.util.HashMap;
import java.util.Map;

public class LocalInventoryService implements InventoryService {

	private Map<Long, InventoryItem> items = new HashMap<>();
	
	@Override
	public void createItem(Long catalogItemId, String name) {
		long inventoryItemId = items.size() + 1;
		this.items.put(inventoryItemId, new InventoryItem(inventoryItemId, catalogItemId, name, 0L));
	}

	@Override
	public Long getQuantity(Long catalogItemId) {
		return 0L;
	}

}

package com.linkedin.jsf;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

@ApplicationScoped
@RemoteService
public class RemoteInventoryService implements InventoryService {

	private String apiUrl = "http://localhost:8080/hsports-catalog-jax/hsports/api/";

	@Override
	public void createItem(Long catalogItemId, String name) {
		
		Client client = ClientBuilder.newClient();
		Response response = client.target(apiUrl)
			.path("inventoryitems")
			.request()
			.post(Entity.json(new InventoryItem(null, catalogItemId, name, (long) new Random().nextInt(10))));
		
		System.out.println(response.getStatus());
		System.out.println(response.getLocation().getPath());
	}
	
	@Override
	public Long getQuantity(Long catalogItemId) {
		Client client = ClientBuilder.newClient();
		InventoryItem inventoryItem = client.target(apiUrl).path("inventoryitems").path("catalog")
			.queryParam("catalogItemId", catalogItemId.toString())
			.request().get(InventoryItem.class);
		return inventoryItem.getQuantity();
	}

	
	
	
	
	
	
	
	
	
	
	
}
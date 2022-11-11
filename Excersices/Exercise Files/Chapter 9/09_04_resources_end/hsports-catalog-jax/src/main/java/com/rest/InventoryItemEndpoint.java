package com.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.linkedin.InventoryItem;

@RequestScoped
@Path("/inventoryitems")
@Produces("application/json")
@Consumes("application/json")
public class InventoryItemEndpoint {

	@POST
	public Response create(final InventoryItem inventoryitem) {
		//TODO: process the given inventoryitem 
		//you may want to use the following return statement, assuming that InventoryItem#getId() or a similar method 
		//would provide the identifier to retrieve the created InventoryItem resource:
		//return Response.created(UriBuilder.fromResource(InventoryItemEndpoint.class).path(String.valueOf(inventoryitem.getId())).build()).build();
		return Response.created(null).build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {

		InventoryItem inventoryitem = new InventoryItem(1L, 1L, "Mittens", 100L); 
		if (inventoryitem == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(inventoryitem).build();
	}

	@GET
	public List<InventoryItem> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the inventoryitems 
		final List<InventoryItem> inventoryitems = null;
		return inventoryitems;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final InventoryItem inventoryitem) {
		//TODO: process the given inventoryitem 
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the inventoryitem matching by the given id 
		return Response.noContent().build();
	}

}

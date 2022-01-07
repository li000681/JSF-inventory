package com.algonquincollege.cst8277.regionalInventory.model;

import java.time.Instant;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InventoryPojoListener {

	private static final Logger LOG = LogManager.getLogger();

	@PrePersist
	public void setCreatedOnDate( InventoryPojo inventory) {
		LOG.debug( "Inventory @PrePersist before = {}", inventory);
		Instant now = Instant.now();
		inventory.setCreated( now);
		//might as well call setUpdatedDate as well
		inventory.setUpdated( now);
		LOG.debug( "Inventory @PrePersist after = {}", inventory);
	}

	@PostPersist
	public void postPersist( InventoryPojo inventory) {
		LOG.debug( "Inventory @PostPersist = {}", inventory);
	}

	@PreUpdate
	public void setUpdatedDate( InventoryPojo inventory) {
		LOG.debug( "Inventory @PreUpdate before = {}", inventory);
		inventory.setUpdated( Instant.now());
		LOG.debug( "Inventory @PreUpdate after = {}", inventory);
	}
}

/*****************************************************************
 * c******************o*******v******id******** File: InventoryPojo.java Course materials (20F) CST 8277
 * 
 * @author (original) Mike Norman
 *
 */
package com.algonquincollege.cst8277.regionalInventory.model;

import java.io.Serializable;
import java.time.Instant;

import javax.faces.view.ViewScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/*
 * this scope is not like @SessionScoped or @RequestScoped about *how many* instances or *how long* they are within
 * scope in the app. Instead, it is about *where* the object is in scope, which is the view - essentially even though it
 * is *defined* in Java, @ViewScoped objects really belong to the XHTML part of the app.
 */
@ViewScoped
@Entity( name = "Inventory")
@Table( name = "regional_inventory", catalog = "regionalinventory")
@Access( AccessType.PROPERTY)
@EntityListeners( { InventoryPojoListener.class })
@NamedQueries( { @NamedQuery( name = InventoryPojo.INVENTORY_FIND_ALL, query = "SELECT a FROM Inventory a"),
		@NamedQuery( name = InventoryPojo.INVENTORY_FIND_ID, query = "SELECT a FROM Inventory a WHERE a.id = :id") })
public class InventoryPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String INVENTORY_FIND_ALL = "Inventory.findAll";
	public static final String INVENTORY_FIND_ID = "Inventory.findId";

	private int id;
	private String retailerName;
	private String region;
	private int level;
	private long epochCreated;
	private long epochUpdated;
	private int version = 1;
	private Instant updated;
	private Instant created;
	private boolean editable;

	@Transient
	public boolean getEditable() {
		return editable;
	}

	public void setEditable( boolean editable) {
		this.editable = editable;
	}

	@Transient
	public Instant getCreated() {
		if ( created == null)
			setCreatedEpochMilli( epochCreated);
		return created;
	}

	@Basic( optional = false)
	@Column( name = "created")
	public long getCreatedEpochMilli() {
		if ( created == null)
			return epochCreated;
		return created.toEpochMilli();
	}

	public void setCreated( Instant created) {
		this.created = created;
	}

	public void setCreatedEpochMilli( long created) {
		this.created = Instant.ofEpochMilli( created);
	}

	@Transient
	public Instant getUpdated() {
		if ( updated == null)
			setUpdatedEpochMilli( epochUpdated);
		return updated;
	}

	@Basic( optional = false)
	@Column( name = "updated")
	public long getUpdatedEpochMilli() {
		if ( updated == null)
			return epochUpdated;
		return updated.toEpochMilli();
	}

	public void setUpdated( Instant updated) {
		this.updated = updated;
	}

	public void setUpdatedEpochMilli( long updated) {
		this.updated = Instant.ofEpochMilli( updated);
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion( int version) {
		this.version = version;
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name = "INV_ID")
	public int getId() {
		return id;
	}

	public void setId( int id) {
		this.id = id;
	}

	@Basic( optional = false)
	@Column( name = "RETAILER_NAME")
	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName( String retailerName) {
		this.retailerName = retailerName;
	}

	@Basic( optional = false)
	@Column( name = "REGION")
	public String getRegion() {
		return region;
	}

	public void setRegion( String firstName) {
		this.region = firstName;
	}

	@Column( name = "CURR_INV_LEVEL")
	public int getInventoryLevel() {
		return level;
	}

	public void setInventoryLevel( int level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals( Object obj) {
		if ( this == obj) {
			return true;
		}
		if ( !( obj instanceof InventoryPojo)) {
			return false;
		}
		InventoryPojo other = (InventoryPojo) obj;
		if ( id != other.id) {
			return false;
		}
		return true;
	}

}
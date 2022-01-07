package com.algonquincollege.cst8277.regionalInventory.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-02-18T03:03:04.981-0500")
@StaticMetamodel(InventoryPojo.class)
public class InventoryPojo_ {
	public static volatile SingularAttribute<InventoryPojo, Long> createdEpochMilli;
	public static volatile SingularAttribute<InventoryPojo, Long> updatedEpochMilli;
	public static volatile SingularAttribute<InventoryPojo, Integer> version;
	public static volatile SingularAttribute<InventoryPojo, Integer> id;
	public static volatile SingularAttribute<InventoryPojo, String> retailerName;
	public static volatile SingularAttribute<InventoryPojo, String> region;
	public static volatile SingularAttribute<InventoryPojo, Integer> inventoryLevel;
}

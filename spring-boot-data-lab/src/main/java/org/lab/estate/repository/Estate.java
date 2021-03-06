package org.lab.estate.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import com.google.common.base.Objects;

/**
 * A simple object to represent an estate.
 * 
 * @author fsc
 * 
 */
@DynamoDBTable(tableName = "Estates")
public class Estate {

	private String id;

	private String type;
	private String address;
	private long purchaseprice;

	public Estate() {
	}

	public Estate(String type, String address, long purchaseprice) {
		super();
		this.type = type;
		this.address = address;
		this.purchaseprice = purchaseprice;
	}

	@DynamoDBAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@DynamoDBAttribute
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@DynamoDBAttribute
	public long getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(long purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Two Estates will generate the same hashcode if they have exactly the same
	 * values for their description, address, and purchaseprice.
	 * 
	 */
	@Override
	public int hashCode() {
		// Google Guava provides great utilities for hashing
		return Objects.hashCode(type, address, purchaseprice);
	}

	/**
	 * Two Estates are considered equal if they have exactly the same values for
	 * their name, url, and duration.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Estate) {
			Estate other = (Estate) obj;
			// Google Guava provides great utilities for equals too!
			return Objects.equal(type, other.type)
					&& Objects.equal(address, other.address)
					&& purchaseprice == other.purchaseprice;
		} else {
			return false;
		}
	}
}

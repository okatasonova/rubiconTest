package com.rubiconproject.model;

import java.util.Arrays;

public class DataSource {
	private String collectionId;
	private SiteEntry[] sites;
	
	public DataSource(String collectionId, SiteEntry[] sites) {
		this.collectionId = collectionId;
		this.sites = sites;
	}
	
	public String getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}
	public SiteEntry[] getSites() {
		return sites;
	}
	public void setSites(SiteEntry[] sites) {
		this.sites = sites;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collectionId == null) ? 0 : collectionId.hashCode());
		result = prime * result + Arrays.hashCode(sites);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataSource other = (DataSource) obj;
		if (collectionId == null) {
			if (other.collectionId != null)
				return false;
		} else if (!collectionId.equals(other.collectionId))
			return false;
		if (!Arrays.equals(sites, other.sites))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "DataSource [collectionId=" + collectionId + ", sites=" + Arrays.toString(sites) + "]";
	}
}

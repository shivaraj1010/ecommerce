package com.eCommerceProject.Catalogservice.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Version;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Version;


@Document(collection = "catalog service")
public class Catalog {
	@Id
	private String catalogId;
	private String name;
	private String description;
	private String image;
	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Version
	private Integer version;

	public Catalog() {
	}

//	public Catalog(String id, String name, String description, String image) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.description = description;
//		this.image = image;
//	}

	public Catalog(String catalogId, String name, String description, String image, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.catalogId = catalogId;
		this.name = name;
		this.description = description;
		this.image = image;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Catalog [catalogId=" + catalogId + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}

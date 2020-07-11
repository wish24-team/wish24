package com.wish.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Akash.Kushwah
 * @author Ashutosh Kumar Pandey
 * @version 1.0.0.0
 * 
 */
@Entity(name = "navigation_bar")
public class NavigationBar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "navigation_id")
	private Integer navigationId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "parent_id", nullable = false)
	private String parentId;

	@Column(name = "parent_path", nullable = false)
	private String parentPath;

	@Column(name = "depth", nullable = false)
	private String depth;

	@Column(name = "status", nullable = false)
	private Integer status;

	@Column(name = "description")
	private String description;

	/**
	 * @return the navigationId
	 */
	public Integer getNavigationId() {
		return navigationId;
	}

	/**
	 * @param navigationId the navigationId to set
	 */
	 public NavigationBar setNavigationId(Integer navigationId) {
	 this.navigationId = navigationId;
	 return this;
	 }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public NavigationBar setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public NavigationBar setParentId(String parentId) {
		this.parentId = parentId;
		return this;
	}

	/**
	 * @return the depth
	 */
	public String getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public NavigationBar setDepth(String depth) {
		this.depth = depth;
		return this;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public NavigationBar setStatus(Integer status) {
		this.status = status;
		return this;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public NavigationBar setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * @return the parentPath
	 */
	public String getParentPath() {
		return parentPath;
	}

	/**
	 * @param parentPath the parentPath to set
	 */
	public NavigationBar setParentPath(String parentPath) {
		this.parentPath = parentPath;
		return this;
	}

	@Override
	public String toString() {
		return "NavigationBar [navigationId=" + navigationId + ", name=" + name + ", parentId=" + parentId
				+ ", parentPath=" + parentPath + ", depth=" + depth + ", status=" + status + ", description="
				+ description + "]";
	}

}

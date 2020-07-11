package com.wish.Dtos.Request;

public class AddUnderNavigationRequestDto {
	
	private Integer navigationId;
	
	private String name;
	
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
	public AddUnderNavigationRequestDto setNavigationId(Integer navigationId) {
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
	public AddUnderNavigationRequestDto setName(String name) {
		this.name = name;
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
	public AddUnderNavigationRequestDto setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public String toString() {
		return "AddUnderNavigationRequestDto [navigationId=" + navigationId + ", name=" + name + ", description="
				+ description + "]";
	}
	
	
}

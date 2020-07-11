package com.wish.Dtos.Request;

import java.util.List;

/**
 * @author Akash.Kushwah
 * @author Ashutosh Kumar Pandey
 * @version 1.0.0.0
 * 
 */
public class NavigationBarRequestDto {

	private String name;
	
	private String description;
	
	List<NavigationBarRequestDto> childrens;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public NavigationBarRequestDto setName(String name) {
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
	public NavigationBarRequestDto setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * @return the childrens
	 */
	public List<NavigationBarRequestDto> getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens the childrens to set
	 */
	public NavigationBarRequestDto setChildrens(List<NavigationBarRequestDto> childrens) {
		this.childrens = childrens;
		return this;
	}

	@Override
	public String toString() {
		return "NavigationBarRequestDto [name=" + name + ", description=" + description + ", childrens=" + childrens
				+ "]";
	}
	
	
}

package com.wish.Dtos.Request;

public class ChangeParentRequestDto {
	
 private Integer NavigationId;
 
 private Integer parentId;

/**
 * @return the navigationId
 */
public Integer getNavigationId() {
	return NavigationId;
}

/**
 * @param navigationId the navigationId to set
 */
public ChangeParentRequestDto setNavigationId(Integer navigationId) {
	NavigationId = navigationId;
	return this;
}

/**
 * @return the parentId
 */
public Integer getParentId() {
	return parentId;
}

/**
 * @param parentId the parentId to set
 */
public ChangeParentRequestDto setParentId(Integer parentId) {
	this.parentId = parentId;
	return this;
}

@Override
public String toString() {
	return "ChangeParentRequestDto [NavigationId=" + NavigationId + ", parentId=" + parentId + "]";
}
 
 
 

}

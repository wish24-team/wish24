package com.wish.Dtos.Request;

public class NavigationNextLayerRequestDto {
private String navigationId;

/**
 * @return the navigationId
 */
public String getNavigationId() {
	return navigationId;
}

/**
 * @param navigationId the navigationId to set
 */
public NavigationNextLayerRequestDto setNavigationId(String navigationId) {
	this.navigationId = navigationId;
	return this;
}

@Override
public String toString() {
	return "NavigationNextLayerRequestDto [navigationId=" + navigationId + "]";
}

}

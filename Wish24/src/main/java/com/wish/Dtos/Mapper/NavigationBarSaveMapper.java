package com.wish.Dtos.Mapper;

import com.wish.Constant.RestConstant;
import com.wish.Dtos.Request.NavigationBarRequestDto;
import com.wish.Model.NavigationBar;

public final class NavigationBarSaveMapper {

	public NavigationBarSaveMapper() {
	}

public static NavigationBar toModel(NavigationBarRequestDto navigationBarRequestDto,String depth,String parentId,String parentPath){
	
	return new NavigationBar()
			.setDepth(depth)
			.setStatus(RestConstant.INT_ONE)
			.setParentId(parentId)
			.setParentPath(parentPath)
			.setDescription(navigationBarRequestDto.getDescription())
			.setName(navigationBarRequestDto.getName());
}
}

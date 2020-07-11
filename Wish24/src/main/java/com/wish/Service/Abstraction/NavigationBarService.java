package com.wish.Service.Abstraction;

import java.util.List;

import javax.validation.Valid;

import com.wish.Dtos.Request.AddUnderNavigationRequestDto;
import com.wish.Dtos.Request.ChangeParentRequestDto;
import com.wish.Dtos.Request.NavigationBarRequestDto;
import com.wish.Dtos.Request.NavigationNextLayerRequestDto;
import com.wish.Model.NavigationBar;

/**
 * @author Akash.Kushwah
 * @author Ashutosh Kumar Pandey
 * @version 1.0.0.0
 * 
 */
public interface NavigationBarService {

	boolean saveNavigation(NavigationBarRequestDto navigationBarRequestDto);

	List<NavigationBar> depthZeroNavigationList();

	List<NavigationBar> getNavigationNextLayer(NavigationNextLayerRequestDto navigationNextLayerRequestDto);

	boolean addUnderNavigation(AddUnderNavigationRequestDto addUnderNavigationRequestDto);

	boolean updateNavigation(AddUnderNavigationRequestDto updateDto);

	boolean changeParent(@Valid ChangeParentRequestDto changeParentRequestDto);

	boolean activeInactiveNavigation(@Valid NavigationNextLayerRequestDto navigationNextLayerRequestDto);

	List<NavigationBar> allInactiveNavigation();

}

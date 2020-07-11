package com.wish.Controller;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wish.Constant.RestConstant;
import com.wish.Dtos.Request.AddUnderNavigationRequestDto;
import com.wish.Dtos.Request.ChangeParentRequestDto;
import com.wish.Dtos.Request.NavigationBarRequestDto;
import com.wish.Dtos.Request.NavigationNextLayerRequestDto;
import com.wish.Exception.CustomException;
import com.wish.Model.NavigationBar;
import com.wish.Service.Abstraction.NavigationBarService;
import com.wish.Utils.Response;
import com.wish.Utils.ResponseModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Objects;

/**
 * @author Akash.Kushwah
 * @author Ashutosh Kumar Pandey
 * @version 1.0.0.0
 * 
 */
@Api(value = "Wish24 Navigation Bar Controller", tags = "Wish24 Navigation Bar Controller")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(RestConstant.WISH24_NAVIGATION_BAR)
public class NavigationBarController {

	private final Logger logger = Logger.getLogger(NavigationBarController.class);
	
	private final NavigationBarService navigationBarService;

	public NavigationBarController(NavigationBarService navigationBarService) {
		this.navigationBarService = navigationBarService;
	}
	
	@ApiOperation(value = "Save Navigation Bar List")
    @PostMapping({RestConstant.V1 + RestConstant.SAVE_NAVIGATION_BAR})
	public ResponseEntity<Response> saveNavigationBar(@Valid @RequestBody NavigationBarRequestDto navigationBarRequestDto, Errors error){
		logger.info("userRegistsaveNavigationBar Method Called in NavigationBarController Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		if (error.hasErrors()) {
            logger.info("Validation");
            throw CustomException.throwException("Please provide valid data!");
        }
		boolean statusOfSaveNavigation= navigationBarService.saveNavigation(navigationBarRequestDto);
		if(statusOfSaveNavigation) {
			logger.info("Successfully saved Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			return ResponseEntity.ok(new ResponseModel()
                    .setMessage(RestConstant.NAVIGATION_SAVED)
                    .setStatus(RestConstant.INT_ONE)
                    .setObject(null));
		}
		logger.info("UnSuccess saved Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		return ResponseEntity.ok(new ResponseModel()
                .setMessage(RestConstant.FAIL)
                .setStatus(RestConstant.INT_ZERO)
                .setObject(null));
	}
	
	@ApiOperation(value = "List of Depth Zero Navigation Bar")
    @GetMapping({RestConstant.V1 + RestConstant.DEPTH_ZERO_NAVIGATION_LIST})
	public ResponseEntity<Response> depthZeroNavigationList(){
		logger.info("depthZeroNavigationList Method Called in NavigationBarController Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		
		List<NavigationBar> navigationList= navigationBarService.depthZeroNavigationList();
		if(Objects.nonNull(navigationList)) {
			logger.info("depthZeroNavigationList Fetch successfully Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			return ResponseEntity.ok(new ResponseModel()
                    .setMessage(RestConstant.SF)
                    .setStatus(RestConstant.INT_ONE)
                    .setObject(navigationList));
		}
		logger.info("UnSuccess depthZeroNavigationList Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		return ResponseEntity.ok(new ResponseModel()
                .setMessage(RestConstant.FAIL)
                .setStatus(RestConstant.INT_ZERO)
                .setObject(null));
	}
	
	@ApiOperation(value = "Get Next Layer Of Navigation Bar")
    @PostMapping({RestConstant.V1 + RestConstant.NAVIGATION_NEXT_LAYER})
	public ResponseEntity<Response> getNavigationNextLayer(@Valid @RequestBody NavigationNextLayerRequestDto navigationNextLayerRequestDto, Errors error){
		logger.info("getNavigationNextLayer Method Called in NavigationBarController Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		if (error.hasErrors()) {
            logger.info("Validation");
            throw CustomException.throwException("Please provide valid data!");
        }
		List<NavigationBar> nextLayerList= navigationBarService.getNavigationNextLayer(navigationNextLayerRequestDto);
		if(Objects.nonNull(nextLayerList)) {
			logger.info("getNavigationNextLayer Successfully Fetched Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			return ResponseEntity.ok(new ResponseModel()
                    .setMessage(RestConstant.SF)
                    .setStatus(RestConstant.INT_ONE)
                    .setObject(nextLayerList));
		}
		logger.info("UnSuccess Fetched Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		return ResponseEntity.ok(new ResponseModel()
                .setMessage(RestConstant.FAIL)
                .setStatus(RestConstant.INT_ZERO)
                .setObject(null));
	}
	
	@ApiOperation(value = "Add Under Navigation")
    @PostMapping({RestConstant.V1 + RestConstant.ADD_UNDER_NAVIATION})
	public ResponseEntity<Response> addUnderNavigation(@Valid @RequestBody AddUnderNavigationRequestDto addUnderNavigationRequestDto, Errors error){
		logger.info("addUnderNavigation Method Called in NavigationBarController Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		if (error.hasErrors()) {
            logger.info("Validation");
            throw CustomException.throwException("Please provide valid data!");
        }
		boolean statusOfSaveNavigation= navigationBarService.addUnderNavigation(addUnderNavigationRequestDto);
		if(statusOfSaveNavigation) {
			logger.info("Successfully saved Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			return ResponseEntity.ok(new ResponseModel()
                    .setMessage(RestConstant.NAVIGATION_SAVED)
                    .setStatus(RestConstant.INT_ONE)
                    .setObject(null));
		}
		logger.info("UnSuccess saved Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		return ResponseEntity.ok(new ResponseModel()
                .setMessage(RestConstant.FAIL)
                .setStatus(RestConstant.INT_ZERO)
                .setObject(null));
	}
	
	
	@ApiOperation(value = "Update Navigation ")
    @PostMapping({RestConstant.V1 + RestConstant.UPDATE_NAVIGATION})
	public ResponseEntity<Response> updateNavigation(@Valid @RequestBody AddUnderNavigationRequestDto updateDto, Errors error){
		logger.info("updateNavigation Method Called in NavigationBarController Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		if (error.hasErrors()) {
            logger.info("Validation");
            throw CustomException.throwException("Please provide valid data!");
        }
		boolean statusOfSaveNavigation= navigationBarService.updateNavigation(updateDto);
		if(statusOfSaveNavigation) {
			logger.info("Successfully updateNavigation Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			return ResponseEntity.ok(new ResponseModel()
                    .setMessage(RestConstant.UPDATE_SUCCESS)
                    .setStatus(RestConstant.INT_ONE)
                    .setObject(null));
		}
		logger.info("UnSuccess updateNavigation Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		return ResponseEntity.ok(new ResponseModel()
                .setMessage(RestConstant.FAIL)
                .setStatus(RestConstant.INT_ZERO)
                .setObject(null));
	}
	
	@ApiOperation(value = "Change Parent of Navigation")
    @PostMapping({RestConstant.V1 + RestConstant.CHANGE_PARENT})
	public ResponseEntity<Response> changeParent(@Valid @RequestBody ChangeParentRequestDto changeParentRequestDto, Errors error){
		logger.info("changeParent Method Called in NavigationBarController Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		if (error.hasErrors()) {
            logger.info("Validation");
            throw CustomException.throwException("Please provide valid data!");
        }
		boolean statusOfSaveNavigation= navigationBarService.changeParent(changeParentRequestDto);
		if(statusOfSaveNavigation) {
			logger.info("Successfully changeParent Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			return ResponseEntity.ok(new ResponseModel()
                    .setMessage(RestConstant.NAVIGATION_SAVED)
                    .setStatus(RestConstant.INT_ONE)
                    .setObject(null));
		}
		logger.info("UnSuccess changeParent Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		return ResponseEntity.ok(new ResponseModel()
                .setMessage(RestConstant.FAIL)
                .setStatus(RestConstant.INT_ZERO)
                .setObject(null));
	}
	
	@ApiOperation(value = "Active Or InActive Navigation")
    @PostMapping({RestConstant.V1 + RestConstant.ACTIVE_INACTIVE_NAVIGATION})
	public ResponseEntity<Response> activeInactiveNavigation(@Valid @RequestBody NavigationNextLayerRequestDto navigationNextLayerRequestDto, Errors error){
		logger.info("activeInactiveNavigation Method Called in NavigationBarController Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		if (error.hasErrors()) {
            logger.info("Validation");
            throw CustomException.throwException("Please provide valid data!");
        }
		boolean status= navigationBarService.activeInactiveNavigation(navigationNextLayerRequestDto);
		if(status) {
			logger.info("activeInactiveNavigation Successfully  Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			return ResponseEntity.ok(new ResponseModel()
                    .setMessage(RestConstant.NAVIGATION_SAVED)
                    .setStatus(RestConstant.INT_ONE)
                    .setObject(null));
		}
		logger.info("UnSuccess activeInactiveNavigation Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		return ResponseEntity.ok(new ResponseModel()
                .setMessage(RestConstant.FAIL)
                .setStatus(RestConstant.INT_ZERO)
                .setObject(null));
	}
	
	@ApiOperation(value = "Get All Inactive Naviation Bar")
    @GetMapping({RestConstant.V1 + RestConstant.INACTIVE_NAVIGATION})
	public ResponseEntity<Response> allInactiveNavigation(){
		logger.info("allInactiveNavigation Method Called in NavigationBarController Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		
		List<NavigationBar> navigationList= navigationBarService.allInactiveNavigation();
		if(Objects.nonNull(navigationList)) {
			logger.info("allInactiveNavigation Fetch successfully Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
			return ResponseEntity.ok(new ResponseModel()
                    .setMessage(RestConstant.SF)
                    .setStatus(RestConstant.INT_ONE)
                    .setObject(navigationList));
		}
		logger.info("UnSuccess allInactiveNavigation Line no= "+new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		return ResponseEntity.ok(new ResponseModel()
                .setMessage(RestConstant.FAIL)
                .setStatus(RestConstant.INT_ZERO)
                .setObject(null));
	}
	
}

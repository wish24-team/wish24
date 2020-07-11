package com.wish.Service.Implementation;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author Akash.Kushwah
 * @author Ashutosh Kumar Pandey
 * @version 1.0.0.0
 * 
 */
import org.springframework.stereotype.Service;

import com.wish.Constant.RestConstant;
import com.wish.Dtos.Mapper.NavigationBarSaveMapper;
import com.wish.Dtos.Request.AddUnderNavigationRequestDto;
import com.wish.Dtos.Request.ChangeParentRequestDto;
import com.wish.Dtos.Request.NavigationBarRequestDto;
import com.wish.Dtos.Request.NavigationNextLayerRequestDto;
import com.wish.Exception.CustomException;
import com.wish.Model.NavigationBar;
import com.wish.Repository.NavigationBarRepository;
import com.wish.Service.Abstraction.NavigationBarService;

@Service
public class NavigationBarServiceImpl implements NavigationBarService{

	private static final Logger logger = Logger.getLogger(NavigationBarServiceImpl.class);

	@Autowired
	private final NavigationBarRepository navigationBarRepository;

	public NavigationBarServiceImpl(NavigationBarRepository navigationBarRepository) {
		this.navigationBarRepository = navigationBarRepository;
	}


	@Override
	public boolean saveNavigation(NavigationBarRequestDto navigationBarRequestDto) {
		logger.info("saveNavigation method called in NavigationBarServiceImpl Line No:"
				+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());

		setNavigation(navigationBarRequestDto,RestConstant.INT_ZERO,"","");
		return  true;

	}

	private void setNavigation(NavigationBarRequestDto navigationBarRequestDto,Integer depth,String parentId,String parentPath) {

		NavigationBar model=NavigationBarSaveMapper.toModel(navigationBarRequestDto, depth.toString(), parentId.toString(),parentPath);
		model=navigationBarRepository.save(model);
		depth++;
		parentPath=parentPath.isEmpty()?model.getNavigationId().toString():parentPath+","+model.getNavigationId();
		parentId=model.getNavigationId().toString();
		if(Objects.isNull(navigationBarRequestDto.getChildrens())) {
			return;
		}
		for(int i=0;i<navigationBarRequestDto.getChildrens().size();i++) {
			setNavigation(navigationBarRequestDto.getChildrens().get(i), depth, parentId,parentPath);
		}

	}


	@Override
	public List<NavigationBar> depthZeroNavigationList() {
		logger.info("depthZeroNavigationList method called in NavigationBarServiceImpl Line No:"
				+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		try {
			return navigationBarRepository.findByDepthAndStatus(RestConstant.INT_ZERO.toString(),RestConstant.INT_ONE);
		} catch (Exception e) {
			throw CustomException.throwException(RestConstant.RNF);
		}
	}


	@Override
	public List<NavigationBar> getNavigationNextLayer(NavigationNextLayerRequestDto navigationNextLayerRequestDto) {
		logger.info("getNavigationNextLayer method called in NavigationBarServiceImpl Line No:"
				+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		try {
			return navigationBarRepository.findByParentIdAndStatus(navigationNextLayerRequestDto.getNavigationId(),RestConstant.INT_ONE);
		} catch (Exception e) {
			throw CustomException.throwException(RestConstant.RNF);
		}
	}


	@Override
	public boolean addUnderNavigation(AddUnderNavigationRequestDto addUnderNavigationRequestDto) {
		logger.info("addUnderNavigation method called in NavigationBarServiceImpl Line No:"
				+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		try {
			NavigationBar parentModel=navigationBarRepository.findByNavigationIdAndStatus(addUnderNavigationRequestDto.getNavigationId(),RestConstant.INT_ONE);
			if(Objects.isNull(parentModel)) {
				throw CustomException.throwException(RestConstant.RNF);
			}
			Integer depth=Integer.parseInt(parentModel.getDepth());
			depth++;
			NavigationBar saveMdel=new NavigationBar()
					.setParentPath(parentModel.getParentPath().isEmpty()?parentModel.getNavigationId().toString():parentModel.getParentPath().concat(","+parentModel.getNavigationId().toString()))
					.setStatus(RestConstant.INT_ONE)
					.setParentId(addUnderNavigationRequestDto.getNavigationId().toString())
					.setName(addUnderNavigationRequestDto.getName())
					.setDescription(addUnderNavigationRequestDto.getDescription())
					.setDepth(depth.toString());

			navigationBarRepository.save(saveMdel);
			return true;

		} catch (Exception e) {
			throw CustomException.throwException(RestConstant.RNF);
		}
	}


	@Override
	public boolean updateNavigation(AddUnderNavigationRequestDto updateDto) {
		logger.info("updateNavigation method called in NavigationBarServiceImpl Line No:"
				+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		try {
			NavigationBar updateModel=navigationBarRepository.findByNavigationIdAndStatus(updateDto.getNavigationId(),RestConstant.INT_ONE);
			if(Objects.isNull(updateModel)) {
				throw CustomException.throwException(RestConstant.RNF);
			}
			navigationBarRepository.save( updateModel
					.setName(updateDto.getName())
					.setDescription(updateDto.getDescription()));
			return true;


		} catch (Exception e) {
			throw CustomException.throwException(RestConstant.RNF);
		}
	}


	@Override
	public boolean changeParent(@Valid ChangeParentRequestDto changeParentRequestDto) {
		logger.info("changeParent method called in NavigationBarServiceImpl Line No:"
				+ new Throwable().getStackTrace()[RestConstant.INT_ZERO].getLineNumber());
		try {
			NavigationBar changeModel=navigationBarRepository.findByNavigationIdAndStatus(changeParentRequestDto.getNavigationId(),RestConstant.INT_ONE);
			if(Objects.isNull(changeModel)) {
				throw CustomException.throwException(RestConstant.RNF);
			}
			if(changeParentRequestDto.getParentId()!=RestConstant.INT_ZERO) {
				NavigationBar parentModel=navigationBarRepository.findByNavigationIdAndStatus(changeParentRequestDto.getParentId(),RestConstant.INT_ONE);
				if(Objects.isNull(parentModel)) {
					throw CustomException.throwException(RestConstant.RNF);
				}
				Integer depth=Integer.parseInt(parentModel.getDepth());
				depth++;
				navigationBarRepository.save( changeModel
				.setParentPath(parentModel.getParentPath().isEmpty()?parentModel.getNavigationId().toString():parentModel.getParentPath().concat(","+parentModel.getNavigationId().toString()))
				.setParentId(parentModel.getNavigationId().toString())
				.setDepth(depth.toString()));
			}
			else {
				navigationBarRepository.save( changeModel
						.setParentPath("")
						.setParentId("")
						.setDepth(RestConstant.INT_ZERO.toString()));
			}
			return true;


		} catch (Exception e) {
			throw CustomException.throwException(RestConstant.RNF);
		}
	}


	@Override
	public boolean activeInactiveNavigation(@Valid NavigationNextLayerRequestDto navigationNextLayerRequestDto) {
		try {
			NavigationBar model=navigationBarRepository.findById(Integer.parseInt(navigationNextLayerRequestDto.getNavigationId())).get();
			if(Objects.isNull(model)) {
				throw CustomException.throwException(RestConstant.RNF);
			}
			navigationBarRepository.save(model.setStatus(model.getStatus()==RestConstant.INT_ONE?RestConstant.INT_ZERO:RestConstant.INT_ONE));
		return true;
		} catch (Exception e) {
			throw CustomException.throwException(RestConstant.RNF);
		}
		
	}


	@Override
	public List<NavigationBar> allInactiveNavigation() {
		try {
			return navigationBarRepository.findByStatus(RestConstant.INT_ZERO);
		} catch (Exception e) {
			throw CustomException.throwException(RestConstant.RNF);
		}
	}

}

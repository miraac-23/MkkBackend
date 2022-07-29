package gabim.permissionTrackingApplication.service;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.dto.Position.PositionCreateDto;
import gabim.permissionTrackingApplication.dto.Position.PositionDto;
import gabim.permissionTrackingApplication.dto.Position.PositionListDto;
import gabim.permissionTrackingApplication.entity.PositionEntity;

public interface PositionService {
	
	DataResult<List<PositionListDto>> getAll();
	
	Result add(PositionCreateDto positionCreateDto);
	
	Result delete(PositionEntity positionEntity);
	
	PositionEntity getPosition(String name);

	


}

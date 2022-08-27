package gabim.permissionTrackingApplication.service;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.dto.Permission.*;
import gabim.permissionTrackingApplication.entity.PermissionEntity;

public interface PermissionService {

	DataResult<List<PermissionListDto>> getAll();

	Result add(PermissionCreateDto permissionCreateDto);

	Result delete(PermissionEntity permissionEntity);

	DataResult<List<PermissionWithEmployeeAndPermissionTypeDto>> getPermissionWithEmployeeAndPermissionType();
	DataResult<PermissionDto> getById(Integer id);

	DataResult<List<PermissionDaySum>> getPermissionDaySum();

}


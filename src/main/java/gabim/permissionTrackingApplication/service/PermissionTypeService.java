package gabim.permissionTrackingApplication.service;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.core.utilities.results.SuccessDataResult;
import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeCreateDto;
import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeListDto;
import gabim.permissionTrackingApplication.entity.PermissionTypeEntity;

public interface PermissionTypeService {
	SuccessDataResult<List<PermissionTypeListDto>> getAll();
	Result add(PermissionTypeCreateDto permissionTypeCreateDto);
	Result delete(PermissionTypeEntity permissionTypeEntity);
	


}

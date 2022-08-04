package gabim.permissionTrackingApplication.service;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.dto.Permission.PermissionCreateDto;
import gabim.permissionTrackingApplication.dto.Permission.PermissionDto;
import gabim.permissionTrackingApplication.dto.Permission.PermissionListDto;
import gabim.permissionTrackingApplication.dto.Permission.PermissionWithEmployeeAndPermissionTypeDto;
import gabim.permissionTrackingApplication.entity.PermissionEntity;

public interface PermissionService {

	DataResult<List<PermissionListDto>> getAll();

	Result add(PermissionCreateDto permissionCreateDto);

	Result delete(PermissionEntity permissionEntity);

	DataResult<List<PermissionWithEmployeeAndPermissionTypeDto>> getPermissionWithEmployeeAndPermissionType();

}

//	DataResult<List<EmployeeWithDepartmentAndPositionDto>> getEmployeeWithPosition();
//DataResult<List<DepartmentOzetDto>> getAll();
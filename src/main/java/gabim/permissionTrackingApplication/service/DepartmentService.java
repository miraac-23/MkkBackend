package gabim.permissionTrackingApplication.service;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.dto.Department.DepartmentCreateDto;
import gabim.permissionTrackingApplication.dto.Department.DepartmentOzetDto;
import gabim.permissionTrackingApplication.entity.DepartmentEntity;

public interface DepartmentService {
	Result add(DepartmentCreateDto departmentCreateDto);
	DataResult<List<DepartmentOzetDto>> getAll();
	Result delete(DepartmentEntity departmentEntity);

}

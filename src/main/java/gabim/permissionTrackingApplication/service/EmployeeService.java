package gabim.permissionTrackingApplication.service;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.dto.Employee.*;
import gabim.permissionTrackingApplication.entity.EmployeeEntity;

public interface EmployeeService {
	Result add(EmployeeCreateDto employeeCreateDto);
	DataResult<List<EmployeeWithDepartmentAndPositionDto>> getAll();
	Result delete(EmployeeEntity employeeEntity);
	Result update(EmployeeUpdateDto employeeUpdateDto );

	DataResult<List<EmployeeWithDepartmentAndPositionDto>> getEmployeeWithPosition();

	DataResult<EmployeeEntity> getByEmployeeName(String employeeName);

	DataResult<EmployeeDto> getById(Integer id);





}

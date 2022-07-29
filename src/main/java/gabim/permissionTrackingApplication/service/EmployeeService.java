package gabim.permissionTrackingApplication.service;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.dto.Employee.*;
import gabim.permissionTrackingApplication.entity.EmployeeEntity;

public interface EmployeeService {
	Result add(EmployeeCreateDto employeeCreateDto);
	DataResult<List<EmployeeListDto>> getAll();
	Result delete(EmployeeEntity employeeEntity);
	Result update(EmployeeUpdateDto employeeUpdateDto , Integer id);

	//EmployeeUpdateDto getById(Integer id);

	DataResult<EmployeeUpdateDto> getById(Integer id);

	//DataResult<EmployeeUpdateDto> getByName(String name);



	DataResult<EmployeeListDto> getByName(String name);
	DataResult<EmployeeListDto> getByNameAndId(String name, int id);
	DataResult<List<EmployeeListDto>> getByNameOrId(String name, int id);
	DataResult<List<EmployeeListDto>> getByNameStartsWith(String name);
	DataResult<List<EmployeeWithPositionDto>> getEmployeeWithPositionDetails();


}

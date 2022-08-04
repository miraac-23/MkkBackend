package gabim.permissionTrackingApplication.mapper;

import java.util.List;

import gabim.permissionTrackingApplication.dto.Department.DepartmentOzetDto;
import gabim.permissionTrackingApplication.dto.Employee.*;
import gabim.permissionTrackingApplication.entity.DepartmentEntity;
import org.mapstruct.Mapper;

import gabim.permissionTrackingApplication.entity.EmployeeEntity;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	
    EmployeeDto entityToDto(EmployeeEntity employeeEntity);

    EmployeeEntity dtoToEntity(EmployeeDto employeeDto);

    EmployeeEntity createDtoToEntity(EmployeeCreateDto employeeCreateDto);

    List<EmployeeWithDepartmentAndPositionDto> entityListToDpListDtoList(List<EmployeeEntity> employeeEntityList);

    EmployeeUpdateDto entityToUpdateToDto(EmployeeEntity employeeEntity);

    EmployeeListDto entityToListDto(EmployeeEntity employeeEntity);




    /*
    * 	DepartmentEntity createDtoToEntity(DepartmentCreateDto departmentCreateDto);
	DepartmentOzetDto entityToOzetDto(DepartmentEntity departmentEntity);
	List<DepartmentOzetDto> entityListToOzetDtoList(List<DepartmentEntity> departmentEntityList);*/


   // DepartmentOzetDto entityToOzetDto(DepartmentEntity departmentEntity);
   // List<DepartmentOzetDto> entityListToOzetDtoList(List<DepartmentEntity> departmentEntityList);


}

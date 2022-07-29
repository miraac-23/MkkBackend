package gabim.permissionTrackingApplication.mapper;

import java.util.List;

import gabim.permissionTrackingApplication.dto.Department.DepartmentOzetDto;
import gabim.permissionTrackingApplication.dto.Employee.EmployeeListDto;
import gabim.permissionTrackingApplication.dto.Employee.EmployeeUpdateDto;
import gabim.permissionTrackingApplication.entity.DepartmentEntity;
import org.mapstruct.Mapper;

import gabim.permissionTrackingApplication.dto.Employee.EmployeeCreateDto;
import gabim.permissionTrackingApplication.dto.Employee.EmployeeDto;
import gabim.permissionTrackingApplication.entity.EmployeeEntity;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	
    EmployeeDto entityToDto(EmployeeEntity employeeEntity);

    EmployeeEntity dtoToEntity(EmployeeDto employeeDto);

    List<EmployeeDto> entityListToDtoList(List<EmployeeEntity> employeeEntityList);

    List<EmployeeEntity> dtoListToEntityList(List<EmployeeDto> employeeDtoList);

    EmployeeEntity createDtoToEntity(EmployeeCreateDto employeeCreateDto);

    EmployeeEntity listDtoToEntity(EmployeeListDto employeeListDto);

    List<EmployeeListDto> entityListToListDtoList(List<EmployeeEntity> employeeEntityList);

    EmployeeListDto entityToListDto(EmployeeEntity employeeEntity);

   // EmployeeListDto entityToListDto(EmployeeEntity employeeEntity)

   // DepartmentOzetDto entityToOzetDto(DepartmentEntity departmentEntity);
   // List<DepartmentOzetDto> entityListToOzetDtoList(List<DepartmentEntity> departmentEntityList);


}

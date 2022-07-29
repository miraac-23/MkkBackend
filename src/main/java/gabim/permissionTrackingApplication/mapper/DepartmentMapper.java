package gabim.permissionTrackingApplication.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import gabim.permissionTrackingApplication.dto.Department.DepartmentCreateDto;
import gabim.permissionTrackingApplication.dto.Department.DepartmentDto;
import gabim.permissionTrackingApplication.dto.Department.DepartmentOzetDto;
import gabim.permissionTrackingApplication.entity.DepartmentEntity;
@Mapper(componentModel = "spring")
public interface DepartmentMapper {
	DepartmentDto entityToDto(DepartmentEntity departmentEntity);
	DepartmentEntity dtoToEntity(DepartmentDto departmentDto);
	List<DepartmentDto> entityListToDtoList(List<DepartmentEntity> departmentEntityList);
	List<DepartmentEntity> dtoListToEntityList(List<DepartmentDto> departmentDtoList);
	DepartmentEntity createDtoToEntity(DepartmentCreateDto departmentCreateDto);
	DepartmentOzetDto entityToOzetDto(DepartmentEntity departmentEntity);
	List<DepartmentOzetDto> entityListToOzetDtoList(List<DepartmentEntity> departmentEntityList);

}
//DataResult<List<DepartmentOzetDto>> getAll();
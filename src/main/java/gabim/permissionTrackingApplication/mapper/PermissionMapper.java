package gabim.permissionTrackingApplication.mapper;



import gabim.permissionTrackingApplication.dto.Permission.PermissionCreateDto;
import gabim.permissionTrackingApplication.dto.Permission.PermissionDto;
import gabim.permissionTrackingApplication.dto.Permission.PermissionListDto;
import gabim.permissionTrackingApplication.dto.Permission.PermissionWithEmployeeAndPermissionTypeDto;
import gabim.permissionTrackingApplication.entity.PermissionEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionDto entityToDto(PermissionEntity permissionEntity);

    PermissionEntity dtoToEntity(PermissionDto permissionDto);
    List<PermissionEntity> dtoListToEntityList(List<PermissionDto> permissionDtoList);

    List<PermissionListDto> entityListToPermissionListDtoList(List<PermissionEntity> permissionEntityList);


    PermissionEntity createDtoToEntity(PermissionCreateDto permissionCreateDto);

    List<PermissionWithEmployeeAndPermissionTypeDto> entityListToDpListDtoList(List<PermissionEntity> permissionEntityList);



}

//    List<EmployeeWithDepartmentAndPositionDto> entityListToDpListDtoList(List<EmployeeEntity> employeeEntityList);
/*
DepartmentOzetDto entityToOzetDto(DepartmentEntity departmentEntity);
	List<DepartmentOzetDto> entityListToOzetDtoList(List<DepartmentEntity> departmentEntityList);


	//DataResult<List<DepartmentOzetDto>> getAll();*/
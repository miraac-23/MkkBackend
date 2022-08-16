package gabim.permissionTrackingApplication.mapper;

import java.util.List;

import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeCreateDto;
import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeListDto;
import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeListingDto;
import org.mapstruct.Mapper;

import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeDto;
import gabim.permissionTrackingApplication.entity.PermissionTypeEntity;

@Mapper(componentModel = "spring")
public interface PermissionTypeMapper {
    PermissionTypeDto entityToDto(PermissionTypeEntity permissionTypeEntity);
    PermissionTypeEntity dtoToEntity(PermissionTypeDto permissionTypeDto);
    List<PermissionTypeDto> entityListToDtoList(List<PermissionTypeEntity> permissionTypeEntityList);
    List<PermissionTypeEntity> dtoListToEntityList(List<PermissionTypeDto> permissionTypeDtoList);
    PermissionTypeEntity createDtoToEntity(PermissionTypeCreateDto permissionTypeCreateDto);
    List<PermissionTypeListDto> entityListToListDtoList(List<PermissionTypeEntity> permissionTypeEntityList);

    List<PermissionTypeListingDto> entitiyListToDtoList(List<PermissionTypeEntity> permissionTypeEntityList);



}
//
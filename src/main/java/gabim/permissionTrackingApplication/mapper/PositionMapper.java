package gabim.permissionTrackingApplication.mapper;

import java.util.List;

import gabim.permissionTrackingApplication.dto.Position.PositionCreateDto;
import gabim.permissionTrackingApplication.dto.Position.PositionListDto;
import org.mapstruct.Mapper;

import gabim.permissionTrackingApplication.dto.Position.PositionDto;
import gabim.permissionTrackingApplication.entity.PositionEntity;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    PositionDto entityToDto(PositionEntity positionEntity);

    PositionEntity dtoToEntity(PositionDto positionDto);

    PositionEntity createDtoToEntity(PositionCreateDto positionCreateDto);

    List<PositionListDto> entityListToPositionListDtoList(List<PositionEntity> positionEntityList);

    List<PositionDto> entityListToDtoList(List<PositionEntity> positionEntityList);

    List<PositionEntity> dtoListToEntityList(List<PositionDto> positionDtoList);
	

}

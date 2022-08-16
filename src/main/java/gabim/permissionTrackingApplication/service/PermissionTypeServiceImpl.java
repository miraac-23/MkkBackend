package gabim.permissionTrackingApplication.service;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.*;
import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeCreateDto;
import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeDto;
import gabim.permissionTrackingApplication.mapper.PermissionTypeMapper;
import gabim.permissionTrackingApplication.repository.PermissionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabim.permissionTrackingApplication.entity.PermissionTypeEntity;

@Service
public class PermissionTypeServiceImpl implements PermissionTypeService {
	private  PermissionTypeRepository permissionTypeRepository;
	private  PermissionTypeMapper permissionTypeMapper;

	@Autowired
	public void setPermissionTypeMapper(PermissionTypeMapper permissionTypeMapper) {
		this.permissionTypeMapper = permissionTypeMapper;
	}

	@Autowired
	public void setPermissionTypeRepository(PermissionTypeRepository permissionTypeRepository){
		this.permissionTypeRepository = permissionTypeRepository;

	}

	@Override
	public Result add(PermissionTypeCreateDto permissionTypeCreateDto) {
		try{
			PermissionTypeEntity permissionTypeEntity = permissionTypeMapper.createDtoToEntity(permissionTypeCreateDto);

			permissionTypeRepository.save(permissionTypeEntity);

			return new SuccessResult("İzin Türü Eklendi");
		}catch (Exception e){
			return new ErrorResult("İzin Türü Eklenmesi Başarısız. Hata: " + e.getMessage());
		}
	}
	@Override
	public SuccessDataResult<List<PermissionTypeDto>> getAll() {
		List<PermissionTypeEntity> permissionTypeList = permissionTypeRepository.findAll();
		return new SuccessDataResult<List<PermissionTypeDto>>(permissionTypeMapper.entityListToDtoList(permissionTypeList),"Data Listelendi");
	}


	@Override
	public Result delete(PermissionTypeEntity permissionTypeEntity) {
		permissionTypeRepository.delete(permissionTypeEntity);
		return new SuccessResult("İzin Türü Silindi");
	}

	

}

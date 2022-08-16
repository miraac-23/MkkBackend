package gabim.permissionTrackingApplication.service;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.*;
import gabim.permissionTrackingApplication.dto.Permission.PermissionCreateDto;
import gabim.permissionTrackingApplication.dto.Permission.PermissionDto;
import gabim.permissionTrackingApplication.dto.Permission.PermissionListDto;
import gabim.permissionTrackingApplication.dto.Permission.PermissionWithEmployeeAndPermissionTypeDto;
import gabim.permissionTrackingApplication.entity.EmployeeEntity;
import gabim.permissionTrackingApplication.entity.PermissionTypeEntity;
import gabim.permissionTrackingApplication.mapper.PermissionMapper;
import gabim.permissionTrackingApplication.repository.EmployeeRepository;
import gabim.permissionTrackingApplication.repository.PermissionRepository;
import gabim.permissionTrackingApplication.repository.PermissionTypeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabim.permissionTrackingApplication.entity.PermissionEntity;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PermissionServiceImpl implements PermissionService {
	private  PermissionMapper permissionMapper;
	private  PermissionRepository permissionRepository;
	private  PermissionTypeRepository permissionTypeRepository;
	private  EmployeeRepository employeeRepository;

	@Autowired
	public PermissionServiceImpl( PermissionRepository permissionRepository, PermissionTypeRepository permissionTypeRepository, EmployeeRepository employeeRepository) {
		this.permissionRepository = permissionRepository;
		this.permissionTypeRepository = permissionTypeRepository;
		this.employeeRepository = employeeRepository;
	}

	@Autowired
	public void setPermissionMapper(PermissionMapper permissionMapper){
		this.permissionMapper = permissionMapper;

	}


	@Override
	public DataResult<List<PermissionListDto>> getAll() {
		List<PermissionEntity> permissionEntityList = permissionRepository.findAll();
		return new SuccessDataResult<List<PermissionListDto>>(permissionMapper.entityListToPermissionListDtoList(permissionEntityList),"Data Listeleme Başarılı") ;
	}

	@Override
	public Result add(PermissionCreateDto permissionCreateDto) {

		try{
			PermissionEntity permissionEntity = permissionMapper.createDtoToEntity(permissionCreateDto);

			PermissionTypeEntity permissionTypeEntity = this.permissionTypeRepository.findById(permissionCreateDto.getPermissionTypeId()).get();
			permissionEntity.setPermissionType(permissionTypeEntity);

			EmployeeEntity employeeEntity = this.employeeRepository.findById(permissionCreateDto.getEmployeeId()).get();
			permissionEntity.setEmployee(employeeEntity);

			permissionEntity.setStartingDate(permissionCreateDto.getStartingDate());
			permissionEntity.setEndDate(permissionCreateDto.getEndDate());
			permissionEntity.setPermissionDay(permissionCreateDto.getPermissionDay());
			permissionEntity.setStatement(permissionCreateDto.getStatement());

			permissionRepository.save(permissionEntity);
			return new SuccessResult("İzin Eklendi");
		}catch (Exception e){
			return new ErrorResult("İzin Eklemesi Başarısız. Hata: " + e.getMessage());
		}
	}



	@Override
	public Result delete(PermissionEntity permissionEntity) {
		try {
			permissionRepository.delete(permissionEntity);
			return new SuccessResult("İzin Silindi");
		}catch (Exception e){
			return new ErrorResult("İzin Silme İşlemi Başarısız. Hata: " + e.getMessage());
		}

	}


	@Override
	public DataResult<List<PermissionWithEmployeeAndPermissionTypeDto>> getPermissionWithEmployeeAndPermissionType() {
		return  new SuccessDataResult<List<PermissionWithEmployeeAndPermissionTypeDto>>(this.permissionRepository.getPermissionWithEmployeeDetails(),"Data Listeleme Başarılı");
	}


}

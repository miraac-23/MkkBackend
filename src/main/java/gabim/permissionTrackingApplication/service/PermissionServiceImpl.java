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
/*
*@Override
	public DataResult<List<DepartmentOzetDto>> getAll() {

		List<DepartmentEntity> departmentList = departmentRepository.findAll();

		return new SuccessDataResult<List<DepartmentOzetDto>>(departmentMapper.entityListToOzetDtoList(departmentList), "Data Listelendi");
	}
	}*/


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


	/*List<EmployeeEntity> employeeListDtoList = employeeRepository.findAll();

		return new SuccessDataResult<List<EmployeeListDto>>(employeeMapper.entityListToListDtoList(employeeListDtoList));*/


	@Override
	public Result delete(PermissionEntity permissionEntity) {
		try {
			permissionRepository.delete(permissionEntity);
			return new SuccessResult("İzin Silindi");
		}catch (Exception e){
			return new ErrorResult("İzin Silme İşlemi Başarısız. Hata: " + e.getMessage());
		}

	}
	/*
	* 	@Override
	public DataResult<List<EmployeeWithDepartmentAndPositionDto>> getEmployeeWithPosition() {

		return new SuccessDataResult<List<EmployeeWithDepartmentAndPositionDto>>(this.employeeRepository.getEmployeeWithPosition(),"Data Listelendi");


	}*/

	@Override
	public DataResult<List<PermissionWithEmployeeAndPermissionTypeDto>> getPermissionWithEmployeeAndPermissionType() {
		return  new SuccessDataResult<List<PermissionWithEmployeeAndPermissionTypeDto>>(this.permissionRepository.getPermissionWithEmployeeDetails(),"Data Listeleme Başarılı");
	}
	/*
	 * private PermissionDao permissionDao;
	 * 
	 * private PermissionTypeDao permissionTypeDao;
	 * 
	 * private EmployeeDao employeeDao;
	 * 
	 * @Autowired public PermissionServiceImpl(PermissionDao permissionDao,
	 * PermissionTypeDao permissionTypeDao, EmployeeDao employeeDao) { super();
	 * this.permissionDao = permissionDao; this.permissionTypeDao =
	 * permissionTypeDao; this.employeeDao = employeeDao; }
	 * 
	 * 
	 * @Override public DataResult<List<PermissionEntity>> getAll() {
	 * 
	 * return new SuccessDataResult<List<PermissionEntity>>
	 * (this.permissionDao.findAll(),"Data Listelendi");
	 * 
	 * }
	 * 
	 * Position position =
	 * this.positionDao.findById(employeeDto.getPositionId()).get();
	 * employee.setPosition(position);
	 * 
	 * 
	 * @Override public Result add(PermissionDto permissionDto) {
	 * 
	 * PermissionEntity permission = new PermissionEntity();
	 * 
	 * 
	 * PermissionTypeEntity permissionType =
	 * this.permissionTypeDao.findById(permissionDto.getPermissionTypeId()).get();
	 * 
	 * EmployeeEntity employee =
	 * this.employeeDao.findById(permissionDto.getEmployeeId()).get();
	 * permission.setEmployee(employee);
	 * 
	 * permission.setPermissionType(permissionType);
	 * 
	 * permission.setStartingDate(permissionDto.getStartingDate());
	 * permission.setEndDate(permissionDto.getEndDate());
	 * permission.setStatement(permissionDto.getStatement());
	 * permission.setPermissionDay(permissionDto.getPermissionDay());
	 * 
	 * //permission.setAdditional(permissionDto.getAdditional());
	 * 
	 * 
	 * this.permissionDao.save(permission); return new
	 * SuccessResult("İzin Eklendi"); }
	 * 
	 * 
	 * @Override public Result delete(PermissionEntity permission) {
	 * 
	 * this.permissionDao.delete(permission);
	 * 
	 * return new SuccessResult("İzin Silindi"); }
	 */

}

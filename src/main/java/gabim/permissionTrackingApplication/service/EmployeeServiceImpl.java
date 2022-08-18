package gabim.permissionTrackingApplication.service;

import java.util.List;
import java.util.Optional;

import gabim.permissionTrackingApplication.core.utilities.results.*;
import gabim.permissionTrackingApplication.dto.Employee.*;
import gabim.permissionTrackingApplication.entity.DepartmentEntity;
import gabim.permissionTrackingApplication.entity.PositionEntity;
import gabim.permissionTrackingApplication.repository.DepartmentRepository;
import gabim.permissionTrackingApplication.repository.EmployeeRepository;
import gabim.permissionTrackingApplication.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabim.permissionTrackingApplication.entity.EmployeeEntity;
import gabim.permissionTrackingApplication.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeMapper employeeMapper;
	private final EmployeeRepository employeeRepository;

	private PositionRepository positionRepository;
	private DepartmentRepository departmentRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository,PositionRepository positionRepository, DepartmentRepository departmentRepository) {
		this.employeeMapper = employeeMapper;
		this.employeeRepository = employeeRepository;
		this.departmentRepository=departmentRepository;
		this.positionRepository=positionRepository;
	}

	@Override
	public Result add(EmployeeCreateDto employeeCreateDto) {

		try{
			EmployeeEntity employeeEntity = employeeMapper.createDtoToEntity(employeeCreateDto);

			PositionEntity positionEntity = this.positionRepository.findById(employeeCreateDto.getPositionId()).get();
			employeeEntity.setPosition(positionEntity);

			DepartmentEntity departmentEntity = this.departmentRepository.findById(employeeCreateDto.getDepartmentId()).get();
			employeeEntity.setDepartment(departmentEntity);

			employeeEntity.setTcNo(employeeCreateDto.getTcNo());
			employeeEntity.setName(employeeCreateDto.getName());
			employeeEntity.setSurname(employeeCreateDto.getSurname());
			employeeEntity.setStartDateOfWork(employeeCreateDto.getStartDateOfWork());
			employeeEntity.setLeaveDateOfWork(employeeCreateDto.getLeaveDateOfWork());
			employeeEntity.setBirthday(employeeCreateDto.getBirthday());
			employeeEntity.setPhoneNumber(employeeCreateDto.getPhoneNumber());
			employeeEntity.setEmail(employeeCreateDto.getEmail());
			employeeEntity.setPassword(employeeCreateDto.getPassword());
			employeeEntity.setUserType(employeeCreateDto.getUserType());

			employeeRepository.save(employeeEntity);
			return new SuccessResult("Personel Eklendi");

		}catch (Exception e){
			return new ErrorResult("Personel Ekleme Başarısız. Hata: " + e.getMessage());
		}
	}

	@Override
	public DataResult<List<EmployeeWithDepartmentAndPositionDto>> getAll() {

		List<EmployeeEntity> employeeListDtoList = employeeRepository.findAll();

		return new SuccessDataResult<List<EmployeeWithDepartmentAndPositionDto>>(employeeMapper.entityListToDpListDtoList(employeeListDtoList),"Data Listelendi");
	}

	@Override
	public DataResult<EmployeeDto> getById(Integer id) {
		EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
		//if null

		return new SuccessDataResult<>(employeeMapper.entityToDto(employeeEntity),"Dad");
	}

	@Override
	public DataResult<EmployeeDto> getByTcNo(Integer tcNo) {

		EmployeeEntity employeeEntity = employeeRepository.getByTcNo(tcNo);
		return new SuccessDataResult<EmployeeDto>(employeeMapper.entityToDto(employeeEntity));

	}


	@Override
	public DataResult<List<EmployeeWithDepartmentAndPositionDto>> getEmployeeWithPosition() {

		return new SuccessDataResult<List<EmployeeWithDepartmentAndPositionDto>>(this.employeeRepository.getEmployeeWithPosition(),"Data Listelendi");


	}


	@Override
	public DataResult<EmployeeEntity> getByEmployeeName(String employeeName) {

		return null;
	}

	@Override
	public Result delete(EmployeeEntity employeeEntity) {
		try {
			employeeRepository.delete(employeeEntity);
			return new SuccessResult("Personel Silme İşlemi Başarılı");
		}catch (Exception e){
			return new ErrorResult("Personel Silme İşlemi Başarısız. Hata: " + e.getMessage());
		}
	}
	@Override
	public Result update(EmployeeUpdateDto employeeUpdateDto) {

		try{
			EmployeeEntity oldEmployee = this.employeeRepository.findById(employeeUpdateDto.getEmployeeId()).get();
					//getEmployee(id);
			oldEmployee.setSurname(employeeUpdateDto.getSurname());
			oldEmployee.setPhoneNumber(employeeUpdateDto.getPhoneNumber());
			oldEmployee.setEmail(employeeUpdateDto.getEmail());
			oldEmployee.setPassword(employeeUpdateDto.getPassword());

			this.employeeRepository.save(oldEmployee);
			return new SuccessResult("Personel Güncellendi");
		}catch (Exception e){
			return new ErrorResult("Personel Güncelleme Başarısız. Hata: " +e.getMessage());
		}
	}








}

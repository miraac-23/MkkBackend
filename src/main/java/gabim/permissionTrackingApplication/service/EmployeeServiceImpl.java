package gabim.permissionTrackingApplication.service;

import java.util.List;

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

	/*
	* List<EmployeeEntity> employeeListDtoList = employeeRepository.findAll();

		return new SuccessDataResult<List<EmployeeWithDepartmentAndPositionDto>>(employeeMapper.entityListToDpListDtoList(employeeListDtoList),"Data Listelendi");*/
	@Override
	public DataResult<List<EmployeeWithDepartmentAndPositionDto>> getEmployeeWithPosition() {

		return new SuccessDataResult<List<EmployeeWithDepartmentAndPositionDto>>(this.employeeRepository.getEmployeeWithPosition(),"Data Listelendi");


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
	public Result update(EmployeeUpdateDto employeeUpdateDto, Integer id) {

		try{
			EmployeeEntity oldEmployee =this.employeeRepository.getById(id);
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

	@Override
	public DataResult<EmployeeUpdateDto> getById(Integer id) {


		return null;

	}


	@Override
	public DataResult<EmployeeListDto> getByName(String name) {

	return new SuccessDataResult<EmployeeListDto>();
	}



	@Override
	public DataResult<EmployeeListDto> getByNameAndId(String name, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<EmployeeListDto>> getByNameOrId(String name, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<EmployeeListDto>> getByNameStartsWith(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<EmployeeWithPositionDto>> getEmployeeWithPositionDetails() {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * private EmployeeDao employeeDao; private PositionDao positionDao; private
	 * DepartmentDao departmentDao;
	 * 
	 * @Autowired public EmployeeServiceImpl(EmployeeDao employeeDao, PositionDao
	 * positionDao, DepartmentDao departmentDao) { super(); this.employeeDao =
	 * employeeDao; this.positionDao = positionDao; this.departmentDao =
	 * departmentDao; }
	 * 
	 * @Override public DataResult<List<EmployeeEntity>> getAll() {
	 * 
	 * return new SuccessDataResult<List<EmployeeEntity>>(this.employeeDao.findAll()
	 * ,"Data Listelendi"); }
	 * 
	 * 
	 * @Override public Result add(EmployeeDto employeeDto) {
	 * 
	 * EmployeeEntity employee = new EmployeeEntity();
	 * 
	 * PositionEntity position =
	 * this.positionDao.findById(employeeDto.getPositionId()).get();
	 * employee.setPosition(position);
	 * 
	 * DepartmentEntity department =
	 * this.departmentDao.findById(employeeDto.getDepartmentId()).get();
	 * employee.setDepartment(department);
	 * 
	 * 
	 * employee.setTcNo(employeeDto.getTcNo());
	 * employee.setName(employeeDto.getName());
	 * employee.setSurname(employeeDto.getSurname());
	 * employee.setStartDateOfWork(employeeDto.getStartDateOfWork());
	 * employee.setLeaveDateOfWork(employeeDto.getLeaveDateOfWork());
	 * employee.setBirthday(employeeDto.getBirthday());
	 * employee.setPhoneNumber(employeeDto.getPhoneNumber());
	 * employee.setEmail(employeeDto.getEmail());
	 * employee.setPassword(employeeDto.getPassword());
	 * employee.setUserType(employeeDto.getUserType());
	 * 
	 * this.employeeDao.save(employee);
	 * 
	 * return new SuccessResult("Personel Eklendi"); }
	 * 
	 * @Override public Result delete(EmployeeEntity employee) {
	 * 
	 * this.employeeDao.delete(employee);
	 * 
	 * return new SuccessResult("Personel Silindi"); }
	 * 
	 * 
	 * @Override public Result update(EmployeeUpdateDto employeeUpdateDto , Integer
	 * id) { EmployeeEntity oldEmployee = getEmployee(id);
	 * 
	 * oldEmployee.setSurname(employeeUpdateDto.getSurname());
	 * oldEmployee.setPhoneNumber(employeeUpdateDto.getPhoneNumber());
	 * oldEmployee.setEmail(employeeUpdateDto.getEmail());
	 * oldEmployee.setPassword(employeeUpdateDto.getPassword());
	 * 
	 * this.employeeDao.save(oldEmployee); return new
	 * SuccessResult("Personel Güncellendi"); }
	 * 
	 * 
	 * @Override public EmployeeEntity getEmployee(Integer id) {
	 * 
	 * return employeeDao.getById(id); }
	 * 
	 * 
	 * 
	 * @Override public DataResult<EmployeeEntity> getByName(String name) { //
	 * business code write here
	 * 
	 * return new
	 * SuccessDataResult<EmployeeEntity>(this.employeeDao.getByName(name),
	 * "Data Listelendi"); }
	 * 
	 * @Override public DataResult<EmployeeEntity> getByNameAndId(String name, int
	 * id) {
	 * 
	 * // business code write here
	 * 
	 * return new
	 * SuccessDataResult<EmployeeEntity>(this.employeeDao.getByNameAndId(name, id),
	 * "Data Listelendi"); }
	 * 
	 * @Override public DataResult<List<EmployeeEntity>> getByNameOrId(String name,
	 * int id) { // business code write here
	 * 
	 * return new
	 * SuccessDataResult<List<EmployeeEntity>>(this.employeeDao.getByNameOrId(name,
	 * id), "Data Listelendi"); }
	 * 
	 * @Override public DataResult<List<EmployeeEntity>> getByNameStartsWith(String
	 * name) { // business code write here
	 * 
	 * return new
	 * SuccessDataResult<List<EmployeeEntity>>(this.employeeDao.getByNameStartsWith(
	 * name), "Data Listelendi"); }
	 * 
	 * @Override public DataResult<List<EmployeeWithPositionDto>>
	 * getEmployeeWithPositionDetails() { // business code write here
	 * 
	 * return new SuccessDataResult<List<EmployeeWithPositionDto>>(this.employeeDao.
	 * getEmployeeWithPositionDetails(),"Data Listelendi"); }
	 * 
	 * 
	 * 
	 */

}

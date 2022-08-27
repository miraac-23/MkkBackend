package gabim.permissionTrackingApplication.repository;

import java.util.List;
import java.util.Optional;


import gabim.permissionTrackingApplication.dto.Employee.*;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gabim.permissionTrackingApplication.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	//EmployeeEntity getById(Integer id);


	Optional<EmployeeEntity> findByName(String name);

	EmployeeEntity getByTcNo(Long tcNo);

	Optional<EmployeeEntity> findByEmail(String email);

	@Query("Select new gabim.permissionTrackingApplication.dto.Employee.EmployeeWithDepartmentAndPositionDto(p.id,p.tcNo,p.name,p.surname,p.startDateOfWork,p.leaveDateOfWork,p.birthday,p.phoneNumber,p.email,p.userType, c.name,m.name) From  DepartmentEntity  c  Inner Join c.employees p Inner Join p.position m ")
	List<EmployeeWithDepartmentAndPositionDto> getEmployeeWithPosition();








}

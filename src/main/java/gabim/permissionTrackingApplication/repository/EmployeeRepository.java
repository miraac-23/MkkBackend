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
	
	EmployeeListDto getByName(String name);

	EmployeeEntity getById(Integer id);


	//EmployeeUpdateDto getByName(String name);

	//EmployeeUpdateDto getById(Integer id);
		
	EmployeeEntity getByNameAndId(String name, int id);
	
	List<EmployeeEntity> getByNameOrId(String name, int id);
	
	List<EmployeeEntity> getByNameStartsWith(String name);

	Optional<EmployeeEntity> findByEmail(String email);


	//@Query("Select new gabim.permissionTrackingApplication.entities.dtos.EmployeeWithPositionDto(e.id,e.name,e.surname,e.userType,c.name) From Position p Inner Join p.employees e")
	
	
	//@Query("Select new gabim.permissionTrackingApplication.entities.dtos.EmployeeWithPositionDto(p.id,p.name,p.surname,p.userType, c.name) From Position c Inner Join c.employees p")
	//List<EmployeeWithPositionDto> getEmployeeWithPositionDetails();

	
	//List<Employee> getById(List<Integer> position);
	@Query("Select new gabim.permissionTrackingApplication.dto.Employee.EmployeeWithDepartmentAndPositionDto(p.id,p.tcNo,p.name,p.surname,p.phoneNumber,p.email,p.userType, c.name) From  DepartmentEntity  c  Inner Join c.employees p ")
	List<EmployeeWithDepartmentAndPositionDto> getEmployeeWithPosition();

	// @Query(value = "SELECT st FROM Student st INNER JOIN FETCH st.branch b INNER JOIN FETCH st.gender g INNER JOIN FETCH st.room r")



}

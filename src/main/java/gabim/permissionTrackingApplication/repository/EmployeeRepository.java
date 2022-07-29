package gabim.permissionTrackingApplication.repository;

import java.util.List;
import java.util.Optional;


import gabim.permissionTrackingApplication.dto.Employee.EmployeeDto;
import gabim.permissionTrackingApplication.dto.Employee.EmployeeListDto;
import gabim.permissionTrackingApplication.dto.Employee.EmployeeLoginDto;
import gabim.permissionTrackingApplication.dto.Employee.EmployeeUpdateDto;
import org.springframework.data.jpa.repository.JpaRepository;

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
	
	

}

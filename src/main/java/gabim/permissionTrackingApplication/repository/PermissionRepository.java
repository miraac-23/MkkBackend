package gabim.permissionTrackingApplication.repository;

import gabim.permissionTrackingApplication.dto.Permission.PermissionWithEmployeeAndPermissionTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gabim.permissionTrackingApplication.entity.PermissionEntity;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {

	PermissionEntity getById(Integer id);

	@Query("Select new gabim.permissionTrackingApplication.dto.Permission.PermissionWithEmployeeAndPermissionTypeDto(p.id,p.startingDate,p.endDate,p.statement,p.permissionDay,m.name,c.name) From EmployeeEntity c Inner Join c.permissions p Inner Join p.permissionType m ")
	List<PermissionWithEmployeeAndPermissionTypeDto> getPermissionWithEmployeeDetails();

	/*
	* 	@Query("Select new gabim.permissionTrackingApplication.dto.Employee.EmployeeWithDepartmentAndPositionDto(p.id,p.tcNo,p.name,p.surname,p.phoneNumber,p.email,p.userType, c.name,m.name) From  DepartmentEntity  c  Inner Join c.employees p Inner Join p.position m ")
	List<EmployeeWithDepartmentAndPositionDto> getEmployeeWithPosition();
*/


}

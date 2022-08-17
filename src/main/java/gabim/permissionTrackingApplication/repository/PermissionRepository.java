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

	@Query("Select new gabim.permissionTrackingApplication.dto.Permission.PermissionWithEmployeeAndPermissionTypeDto(k.id,k.startingDate,k.endDate,k.statement,k.permissionDay,t.name,p.name,p.surname,c.name,m.name) From DepartmentEntity c Inner Join c.employees p Inner Join p.position m Inner Join p.permissions k Inner Join k.permissionType t")
	List<PermissionWithEmployeeAndPermissionTypeDto> getPermissionWithEmployeeDetails();


}







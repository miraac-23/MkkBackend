package gabim.permissionTrackingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gabim.permissionTrackingApplication.entity.PermissionTypeEntity;

@Repository
public interface PermissionTypeRepository extends JpaRepository<PermissionTypeEntity, Integer> {

	
}

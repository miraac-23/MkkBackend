package gabim.permissionTrackingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gabim.permissionTrackingApplication.entity.DepartmentEntity;


@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

	//DepartmentEntity getByName(String name);

}

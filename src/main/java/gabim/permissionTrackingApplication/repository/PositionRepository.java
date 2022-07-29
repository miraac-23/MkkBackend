package gabim.permissionTrackingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gabim.permissionTrackingApplication.entity.PositionEntity;


@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, Integer> {
	

	//PositionEntity getByName(String name);


}

package gabim.permissionTrackingApplication.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import gabim.permissionTrackingApplication.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	

}

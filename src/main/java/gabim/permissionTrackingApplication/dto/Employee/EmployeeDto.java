package gabim.permissionTrackingApplication.dto.Employee;

import java.sql.Date;
import java.util.List;

import gabim.permissionTrackingApplication.dto.Permission.PermissionDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private int tcNo;
	
	private String name;
	
	private String surname;
	
	private Date startDateOfWork;
	
	private Date leaveDateOfWork;
	
	private Date birthday;
	
	private int phoneNumber;
	
	private String email;
	
	private String password;
	
	private String userType;
	
	private int positionId;
	
	private int departmentId;

	//	private List<EmployeeDto> employees;

	private List<PermissionDto> permissions;

}



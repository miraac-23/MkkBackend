package gabim.permissionTrackingApplication.dto.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWithPositionDto {
	
	private int id;
	private String name;
	private String surname;
	private String userType;
	private String positionName;

}

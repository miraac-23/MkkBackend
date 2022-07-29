package gabim.permissionTrackingApplication.dto.Employee;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateDto {

	private int employeeId;
	private int phoneNumber;
	private String surname;
	private String email;
	private String password;
}

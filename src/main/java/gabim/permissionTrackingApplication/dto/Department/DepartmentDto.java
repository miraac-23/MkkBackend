package gabim.permissionTrackingApplication.dto.Department;


import java.util.List;

import gabim.permissionTrackingApplication.dto.Employee.EmployeeDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

	private int id;
	private String name;
	private List<EmployeeDto> employees;
	
}

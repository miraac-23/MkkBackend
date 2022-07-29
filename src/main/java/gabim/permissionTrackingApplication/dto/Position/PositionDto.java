package gabim.permissionTrackingApplication.dto.Position;

import java.util.List;

import gabim.permissionTrackingApplication.dto.Employee.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto {

	private int id;
	private String name;
	private List<EmployeeDto> employees;

}

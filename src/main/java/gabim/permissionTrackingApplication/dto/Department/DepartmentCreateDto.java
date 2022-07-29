package gabim.permissionTrackingApplication.dto.Department;


import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentCreateDto {
	
	@NotBlank(message = "Adı boş olamaz")
	private String name;
}

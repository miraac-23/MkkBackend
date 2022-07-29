package gabim.permissionTrackingApplication.dto.PermissionType;

import java.util.List;

import gabim.permissionTrackingApplication.dto.Permission.PermissionDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionTypeDto {
	

	private int id;
	private String name;
	private List<PermissionDto> permission;

}

package gabim.permissionTrackingApplication.dto.Permission;

import java.sql.Date;
import java.util.List;

import gabim.permissionTrackingApplication.entity.EmployeeEntity;
import gabim.permissionTrackingApplication.entity.PermissionTypeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDto {
	
	private int id;
//	private List<PermissionDto> permission;

	private Date startingDate;

	private Date endDate;

	private String statement;

	private int permissionDay;

/*
* 	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "starting_date")
	private Date startingDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "statement")
	private String statement;


	@Column(name = "permission_day")
	private int permissionDay;*/





}

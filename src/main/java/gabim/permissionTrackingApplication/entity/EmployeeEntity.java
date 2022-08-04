package gabim.permissionTrackingApplication.entity;



import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gabim.permissionTrackingApplication.dto.Employee.EmployeeListDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "tc_no")
	private int tcNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "start_date_of_work")
	private Date startDateOfWork;
	
	@Column(name = "leave_date_of_work")
	private Date leaveDateOfWork;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "phone_number")
	private int phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_type")
	private String userType;
	

	//personel-izin tablosu arasındaki ilişki
	@OneToMany(mappedBy = "employee") 
	private List<PermissionEntity> permissions;

	//personel-unavn tablosu arasındaki ilişki 
	@ManyToOne()
	@JoinColumn(name = "position_id") 
	private PositionEntity position;

	//personel-departman arasındaki	  
	@ManyToOne()
	@JoinColumn(name = "department_id") 
	private DepartmentEntity department;
	 

}

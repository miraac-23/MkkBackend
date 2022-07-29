package gabim.permissionTrackingApplication.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permission")
public class PermissionEntity {
	
	@Id
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
	private int permissionDay;
	 
	
	//@Column(name = "additional")
	///private String additional;
	
	
	
	  //personel izin tablosu arasındaki ilişki
	  
	@ManyToOne()
	@JoinColumn(name = "employee_id") 
	private EmployeeEntity employee;
	  
	  
	//izin-izin_türü arasındaki ilişki	
	@ManyToOne()		  
	@JoinColumn(name = "permission_type_id") 
	private PermissionTypeEntity permissionType;
		 
	 
}

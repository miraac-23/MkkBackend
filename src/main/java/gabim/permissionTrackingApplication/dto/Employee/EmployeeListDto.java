package gabim.permissionTrackingApplication.dto.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeListDto {

    private int id;

    private int tcNo;

    private String name;

    private String surname;

    private Date startDateOfWork;

    private Date leaveDateOfWork;

    private Date birthday;

    private int phoneNumber;

    private String email;

    private String userType;

    private int positionId;

    private int departmentId;

    private String positionName;

    private String departmentName;

}

package gabim.permissionTrackingApplication.dto.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWithDepartmentAndPositionDto {


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

    private String departmentName;

    private String positionName;

}

package gabim.permissionTrackingApplication.dto.Permission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionWithEmployeeAndPermissionTypeDto {

    private int id;

    private Date startingDate;

    private Date endDate;

    private String statement;

    private int permissionDay;

    private String permissionTypeName;

    private String employeeName;

    private String employeeSurname;

    private String employeeDepartment;

    private String employeePosition;
}

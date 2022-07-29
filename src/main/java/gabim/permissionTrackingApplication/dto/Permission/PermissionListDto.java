package gabim.permissionTrackingApplication.dto.Permission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionListDto {

    private int id;
    private Date startingDate;

    private Date endDate;

    private String statement;

    private int permissionDay;

    private int permissionTypeId;

    private int employeeId;
}

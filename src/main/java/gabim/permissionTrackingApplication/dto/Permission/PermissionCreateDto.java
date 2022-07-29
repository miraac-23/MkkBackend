package gabim.permissionTrackingApplication.dto.Permission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionCreateDto {


    private Date startingDate;

    private Date endDate;

    private String statement;

    private int permissionDay;

    private int permissionTypeId;

    private int employeeId;

}

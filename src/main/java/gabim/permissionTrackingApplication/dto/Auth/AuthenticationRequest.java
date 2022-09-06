package gabim.permissionTrackingApplication.dto.Auth;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
    private int employeeId;
}

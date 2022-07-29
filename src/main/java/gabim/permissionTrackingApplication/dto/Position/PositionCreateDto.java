package gabim.permissionTrackingApplication.dto.Position;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PositionCreateDto {

    @NotBlank(message = "Adı boş olamaz")
    private String name;
}

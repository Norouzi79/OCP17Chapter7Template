package ir.dotin.ocp17chapter7template.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "a test dto connected to a model")
public class TestUpdateDto {
    @Schema(description = "id of the model", required = true)
    private Integer id;
    @Schema(description = "name of the model", required = true)
    private String name;
}
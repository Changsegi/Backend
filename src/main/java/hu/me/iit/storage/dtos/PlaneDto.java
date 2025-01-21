package hu.me.iit.storage.dtos;

import hu.me.iit.storage.entities.Owner;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class PlaneDto {
    private Long id;
    @NotNull
    private String p_type;
    @NotNull
    private String p_production_date;

    private Owner owners;
}

package hu.me.iit.storage.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class CarDto {
    private Long id;
    @NotNull
    private String c_type;
    @NotNull
    private String c_production_date;
    private List<OwnerDto> owners;

}

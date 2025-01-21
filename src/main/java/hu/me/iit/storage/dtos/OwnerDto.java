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
public class OwnerDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String address;


    private List<CarDto> cars;

    private List<PlaneDto> planes;

}

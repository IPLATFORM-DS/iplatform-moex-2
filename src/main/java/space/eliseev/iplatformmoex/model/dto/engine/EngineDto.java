package space.eliseev.iplatformmoex.model.dto.engine;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EngineDto {

    public Integer id;
    public String name;
    public String title;

}

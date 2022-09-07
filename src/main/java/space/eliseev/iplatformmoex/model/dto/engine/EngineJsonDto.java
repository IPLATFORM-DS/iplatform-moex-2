package space.eliseev.iplatformmoex.model.dto.engine;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import space.eliseev.iplatformmoex.model.entity.Engine;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(value = { "charsetinfo" })
public class EngineJsonDto {

    public List<Engine> engines;

}
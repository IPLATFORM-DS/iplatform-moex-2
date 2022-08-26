package space.eliseev.iplatformmoex.model.dto.engine;


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
public class EngineJsonDto {

    public Charsetinfo charsetinfo;
    public List<Engine> engines;

}
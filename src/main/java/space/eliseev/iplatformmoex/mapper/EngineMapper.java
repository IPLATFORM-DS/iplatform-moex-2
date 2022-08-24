package space.eliseev.iplatformmoex.mapper;

import org.mapstruct.Mapper;
import space.eliseev.iplatformmoex.model.dto.engine.EngineDto;
import space.eliseev.iplatformmoex.model.entity.Engine;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EngineMapper {

    List<Engine> entityToDto(List<EngineDto> examples);
}
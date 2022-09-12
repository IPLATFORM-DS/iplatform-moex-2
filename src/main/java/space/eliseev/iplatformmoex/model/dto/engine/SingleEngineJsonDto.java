package space.eliseev.iplatformmoex.model.dto.engine;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(value = { "charsetinfo" })
public class SingleEngineJsonDto {
    public List<SingleEngineDTO> engine;
    public List<Timetable> timetable;
    public List<Dailytable> dailytable;
}
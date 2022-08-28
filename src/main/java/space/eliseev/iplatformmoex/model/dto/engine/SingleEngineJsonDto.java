package space.eliseev.iplatformmoex.model.dto.engine;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SingleEngineJsonDto {
    public Charsetinfo charsetinfo;
    public List<SingleEngineDTO> engine;
    public List<Timetable> timetable;
    public List<Dailytable> dailytable;
}

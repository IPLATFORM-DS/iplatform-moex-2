package space.eliseev.iplatformmoex.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EngineParam {
    ENGINE("engine"),
    TIMETABLE("timetable"),
    DAILYTABLE("dailytable");

    private final String name;
}

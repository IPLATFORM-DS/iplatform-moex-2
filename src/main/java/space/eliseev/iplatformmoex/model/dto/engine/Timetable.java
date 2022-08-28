package space.eliseev.iplatformmoex.model.dto.engine;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Timetable {
    @JsonProperty("week_day")
    public Integer weekDay;
    @JsonProperty("is_work_day")
    public Integer isWorkDay;
    @JsonProperty("start_time")
    public String startTime;
    @JsonProperty("stop_time")
    public String stopTime;
}

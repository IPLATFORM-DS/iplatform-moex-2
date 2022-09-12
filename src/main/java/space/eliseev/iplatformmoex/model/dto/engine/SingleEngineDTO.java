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
public class SingleEngineDTO {
    @JsonProperty("NAME")
    public String name;
    @JsonProperty("title")
    public String title;
    @JsonProperty("short_title")
    public String shortTitle;

}
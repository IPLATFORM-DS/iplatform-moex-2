package space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import space.eliseev.iplatformmoex.model.entity.*;

import java.util.List;
@RequiredArgsConstructor
@Getter
@JsonIgnoreProperties(value = { "charsetinfo" })
public class ReferenceWithMOEXJsonDto {
    public List<Engine> engines;
    public List<Market> markets;
    public List<Board> boards;
    public List<BoardGroup> boardgroups;
    public List<Duration> durations;
    public List<SecurityType> securitytypes;
    public List<SecurityGroup> securitygroups;
    public List<SecurityCollection> securitycollections;
}

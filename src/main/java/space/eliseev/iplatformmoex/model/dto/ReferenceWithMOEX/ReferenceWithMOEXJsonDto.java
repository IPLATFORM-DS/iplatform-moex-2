package space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import space.eliseev.iplatformmoex.model.entity.*;

import java.util.List;
@RequiredArgsConstructor
@Getter
public class ReferenceWithMOEXJsonDto {
    public Charsetinfo charsetinfo;
    public List<Engine> engines;
    public List<Market> markets;
    public List<Board> boards;
    public List<BoardGroup> boardgroups;
    public List<Duration> durations;
    public List<SecurityType> securitytypes;
    public List<SecurityGroup> securitygroups;
    public List<SecurityCollection> securitycollections;
}

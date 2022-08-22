package space.eliseev.iplatformmoex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import space.eliseev.iplatformmoex.model.entity.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ReferenceWithMOEX {

    private List<Duration> durations;

    private List<SecurityType> securityTypes;

    private List<SecurityGroup> securityGroups;

    private List<SecurityCollection> securityCollections;

    private List<BoardGroup> boardGroups;

    private List<Engine> engines;

    private List<Market> markets;

    private List<Board> boards;







}

package space.eliseev.iplatformmoex.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "board")
@EqualsAndHashCode
public class Board extends BaseEntity {

    @JsonProperty("board_group_id")
    @Column(name = "board_group_id")
    private Integer boardGroupId;

    @JsonProperty("engine_id")
    @Column(name = "engine_id")
    private Integer engineId;

    @JsonProperty("market_id")
    @Column(name = "market_id")
    private Integer marketId;

    @JsonProperty("boardid")
    @Column(name = "boardid")
    private String boardId;

    @JsonProperty("board_title")
    @Column(name = "board_title")
    private String boardTitle;

    @JsonProperty("is_traded")
    @Column(name = "is_traded")
    private Integer isTraded;

    @JsonProperty("has_candles")
    @Column(name = "has_candles")
    private Integer hasCandles;

    @JsonProperty("is_primary")
    @Column(name = "is_primary")
    private Integer isPrimary;

}

package space.eliseev.iplatformmoex.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "board_group_id")
    private Integer boardGroupId;

    @Column(name = "engine_id")
    private Integer engineId;

    @Column(name = "market_id")
    private Integer marketId;

    @Column(name = "boardid")
    private String boardId;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name = "is_traded")
    private boolean isTraded;

    @Column(name = "has_candles")
    private boolean hasCandles;

    @Column(name = "is_primary")
    private boolean isPrimary;

}

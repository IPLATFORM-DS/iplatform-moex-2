package space.eliseev.iplatformmoex.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "board-group.yaml")
public class BoardGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "trade_engine_id")
    private Integer tradeEngineId;

    @Column(name = "trade_engine_name", length = 45)
    private String tradeEngineName;

    @Column(name = "trade_engine_title", length = 765)
    private String tradeEngineTitle;

    @Column(name = "market_id")
    private Integer marketId;

    @Column(name = "market_name", length = 45)
    private String marketName;

    @Column(name = "name", length = 192)
    private String name;

    @Column(name = "title", length = 765)
    private String title;

    @Column(name = "is_default")
    private Integer isDefault;

    @Column(name = "board_group_id")
    private Integer boardGroupId;

    @Column(name = "is_traded")
    private Integer isTraded;

    @Column(name = "is_order_driven")
    private Integer isOrderDriven;

    @Column(name = "category", length = 45)
    private String category;

}

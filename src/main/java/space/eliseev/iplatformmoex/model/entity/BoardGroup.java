package space.eliseev.iplatformmoex.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "board_group")
public class BoardGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "trade_engine_id")
    private Integer tradeEngineId;

    @Column(name = "trade_engine_name")
    private String tradeEngineName;

    @Column(name = "trade_engine_title")
    private String tradeEngineTitle;

    @Column(name = "market_id")
    private Integer marketId;

    @Column(name = "market_name")
    private String marketName;

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "is_default")
    private Integer isDefault;

    @Column(name = "board_group_id")
    private Integer boardGroupId;

    @Column(name = "is_traded")
    private Integer isTraded;

    @Column(name = "is_order_driven")
    private Integer isOrderDriven;

    @Column(name = "category")
    private String category;

}

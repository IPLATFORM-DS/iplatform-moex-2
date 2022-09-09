package space.eliseev.iplatformmoex.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "board_group")
@EqualsAndHashCode
public class BoardGroup extends BaseEntity {

    @JsonProperty("trade_engine_id")
    @Column(name = "trade_engine_id")
    private Integer tradeEngineId;

    @JsonProperty("trade_engine_name")
    @Column(name = "trade_engine_name")
    private String tradeEngineName;

    @JsonProperty("trade_engine_title")
    @Column(name = "trade_engine_title")
    private String tradeEngineTitle;

    @JsonProperty("market_id")
    @Column(name = "market_id")
    private Integer marketId;

    @JsonProperty("market_name")
    @Column(name = "market_name")
    private String marketName;

    @JsonProperty("name")
    @Column(name = "name",unique = true)
    private String name;

    @JsonProperty("title")
    @Column(name = "title")
    private String title;

    @JsonProperty("is_default")
    @Column(name = "is_default")
    private Integer isDefault;

    @JsonProperty("board_group_id")
    @Column(name = "board_group_id")
    private Integer boardGroupId;

    @JsonProperty("is_traded")
    @Column(name = "is_traded")
    private Integer isTraded;

    @JsonProperty("is_order_driven")
    @Column(name = "is_order_driven")
    private Integer isOrderDriven;

    @JsonProperty("category")
    @Column(name = "category")
    private String category;

}

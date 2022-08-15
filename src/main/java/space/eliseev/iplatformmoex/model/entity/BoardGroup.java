package space.eliseev.iplatformmoex.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "board_group")
public class BoardGroup extends BaseEntity{

    @Column(name = "trade_engine_id")
    private Integer trade_engine_id;

    @Column(name = "trade_engine_name")
    private String trade_engine_name;

    @Column(name = "trade_engine_title")
    private String trade_engine_title;

    @Column(name = "market_id")
    private Integer market_id;

    @Column(name = "market_name")
    private String market_name;

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "is_default")
    private Integer is_default;

    @Column(name = "board_group_id")
    private Integer board_group_id;

    @Column(name = "is_traded")
    private Integer is_traded;

    @Column(name = "is_order_driven")
    private Integer is_order_driven;

    @Column(name = "category")
    private String category;

}

package space.eliseev.iplatformmoex.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "markets")
public class Market {

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

    @Column(name = "market_name")
    private String marketName;

    @Column(name = "market_title")
    private String marketTitle;

    @Column(name = "market_id")
    private Integer marketId;

    @Column(name = "marketplace")
    private String marketplace;

    @Column(name = "is_otc")
    private Integer isOtc;
}

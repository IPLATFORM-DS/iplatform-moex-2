package space.eliseev.iplatformmoex.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "market")
public class Market extends BaseEntity {

    @JsonProperty("trade_engine_id")
    @Column(name = "trade_engine_id")
    private Integer tradeEngineId;

    @JsonProperty("trade_engine_name")
    @Column(name = "trade_engine_name")
    private String tradeEngineName;

    @JsonProperty("trade_engine_title")
    @Column(name = "trade_engine_title")
    private String tradeEngineTitle;

    @JsonProperty("market_name")
    @Column(name = "market_name")
    private String marketName;

    @JsonProperty("market_title")
    @Column(name = "market_title")
    private String marketTitle;

    @JsonProperty("market_id")
    @Column(name = "market_id")
    private Integer marketId;

    @JsonProperty("marketplace")
    @Column(name = "marketplace")
    private String marketplace;

    @JsonProperty("is_otc")
    @Column(name = "is_otc")
    private Integer isOtc;

    @JsonProperty("has_history_files")
    @Column(name = "has_history_files")
    private Integer hasHistoryFiles;

    @JsonProperty("has_history_trades_files")
    @Column(name = "has_history_trades_files")
    private Integer hasHistoryTradesFiles;

    @JsonProperty("has_trades")
    @Column(name = "has_trades")
    private Integer hasTrades;

    @JsonProperty("has_history")
    @Column(name = "has_history")
    private Integer hasHistory;


}


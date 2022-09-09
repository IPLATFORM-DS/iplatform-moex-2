package space.eliseev.iplatformmoex.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "security_type")
@EqualsAndHashCode
public class SecurityType extends BaseEntity {

    @JsonProperty("trade_engine_id")
    @Column(name = "trade_engine_id")
    private Integer tradeEngineId;

    @JsonProperty("trade_engine_name")
    @Column(name = "trade_engine_name")
    private String tradeEngineName;

    @JsonProperty("trade_engine_title")
    @Column(name = "trade_engine_title")
    private String tradeEngineTitle;

    @JsonProperty("security_type_name")
    @Column(name = "security_type_name")
    private String securityTypeName;

    @JsonProperty("security_type_title")
    @Column(name = "security_type_title")
    private String securityTypeTitle;

    @JsonProperty("security_group_name")
    @Column(name = "security_group_name")
    private String securityGroupName;
}

package space.eliseev.iplatformmoex.model.entity;

import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "security_type")
public class SecurityType {

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

    @Column(name = "security_type_name")
    private String securityTypeName;

    @Column(name = "security_type_title")
    private String securityTypeTitle;

    @Column(name = "security_group_name")
    private String securityGroupName;
}

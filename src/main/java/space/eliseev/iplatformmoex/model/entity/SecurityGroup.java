package space.eliseev.iplatformmoex.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "security_group")
public class SecurityGroup extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @JsonProperty("is_hidden")
    @Column(name = "is_hidden")
    private Integer isHidden;
}

package space.eliseev.iplatformmoex.models;

import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "security_collection")
public class SecurityCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "security_group_id")
    private Integer securityGroupId;

}

package space.eliseev.iplatformmoex.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@NoArgsConstructor
public class ReferenceWithMOEX {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "referenceWithMOIX_id")
    private List<Duration> durations;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "referenceWithMOIX_id")
    private List<SecurityType> securityTypes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "referenceWithMOIX_id")
    private List<SecurityGroup> securityGroups;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "referenceWithMOIX_id")
    private List<SecurityCollection> securityCollections;



}

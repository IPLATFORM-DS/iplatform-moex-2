package space.eliseev.iplatformmoex.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="check_metadata")
public class CheckMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;

    @Column(name="timestamp")
    private LocalDateTime timestamp;

    @Column(name="index")
    private String index;

    @Column(name="is_valid")
    private  Boolean isValid;
}

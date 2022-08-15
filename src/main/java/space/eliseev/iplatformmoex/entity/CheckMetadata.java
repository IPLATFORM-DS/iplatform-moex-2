package space.eliseev.iplatformmoex.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="check_metadata")
public class CheckMetadata {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="timestamp")
    private LocalDateTime timestamp;
    @Column(name="index")
    private String index;
    @Column(name="is_valid")
    private  Boolean isValid;


}

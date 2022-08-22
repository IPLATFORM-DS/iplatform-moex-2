package space.eliseev.iplatformmoex.model.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "duration")

public class Duration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "interval")
    private Integer interval;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "days")
    private Integer days;

    @Column(name = "title")
    private String title;

    @Column(name = "hint")
    private String hint;
}

package space.eliseev.iplatformmoex.model.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "engine")
public class Engine extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;
}




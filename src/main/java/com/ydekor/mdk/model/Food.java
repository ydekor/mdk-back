package com.ydekor.mdk.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //след id генерирует db
    private Long id;
    private String name;
    private Integer cost;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
}

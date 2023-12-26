package com.ydekor.mdk.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //след id генерирует db
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department")
    private List<User> users;
}

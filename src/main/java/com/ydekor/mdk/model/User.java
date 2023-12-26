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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private String login;
    private String password;
    private String email;

    @JoinColumn(name = "department_id")
    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "user")
    private List<Food> foods;
}

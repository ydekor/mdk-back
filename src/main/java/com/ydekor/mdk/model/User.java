package com.ydekor.mdk.model;

import jakarta.persistence.*;
import lombok.*;

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
}

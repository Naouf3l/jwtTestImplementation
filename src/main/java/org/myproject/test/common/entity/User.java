package org.myproject.test.common.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "user_info")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "u_id")
    private Long id;

    @Column(name = "u_login")
    private String login;

    @Column(name = "u_password")
    private String password;

    @Column(name = "u_role")
    private String role;
}

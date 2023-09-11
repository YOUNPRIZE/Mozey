package com.ssafy.tenten.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false)
    private Long userId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "term")
    private String term;

    @Column(name = "campus")
    private String campus;

    @Column(name = "group")
    private String group;

    @Column(name = "sub_yn")
    private int subYn;

    @Column(name = "sub_start_time")
    private Date subStartTime;

    @Column(name = "point")
    private int point;

    @Column(name = "coin1")
    private int coin1;

    @Column(name = "coin2")
    private int coin2;

    @Column(name = "withdraw")
    private int withdraw;

    @Column(name = "role")
    private String role;
}

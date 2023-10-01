package com.ssafy.tenten.domain;

import com.ssafy.tenten.vo.Request.UserJoinRequest;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long userId;

    @Column
    private String email;

    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private char gender;

    @Column(name = "img")
    private String image;

    @Column(name = "username")
    private String name;

    @Column(columnDefinition = "CHAR(2)")
    private String term;

    @Column(columnDefinition = "CHAR(10)")
    private String campus;

    @Column(name = "unit", columnDefinition = "CHAR(10)")
    private String group;

    @ColumnDefault("false")
    @Column(columnDefinition = "TINYINT(1)")
    private int subYn;

    @Column(nullable = false)
    private Instant subStartTime;

    @PrePersist
    public void prePersist() {
        if (subStartTime == null) subStartTime = Instant.now();
        if (point == null) point = 0L;
        if (coin1 == null) coin1 = 0L;
        if (coin2 == null) coin2 = 0L;
        if (withdraw == 0) withdraw = 1;
    }

    @Column(nullable = false)
    private Long point;

    @Column(nullable = false)
    private Long coin1;

    @Column(nullable = false)
    private Long coin2;

    @Column(nullable = false)
    private int withdraw;

    @Column(nullable = false, columnDefinition = "char(10)")
    @ColumnDefault("USER")
    private String role;

    private String provider;
    private String providerId;
    private String kakaoToken;
    private String refreshToken; // 리프레시 토큰
    private String firebaseToken;

    public void subscribe() {
        this.subYn = 1;
    }
    public void unsubscribe() {
        this.subYn = 0;
    }

    @Builder
    public User(String email, String name, String term, String campus, String group) {
        this.email = email;
        this.name = name;
        this.term = term;
        this.campus = campus;
        this.group = group;
    }

    public void join(UserJoinRequest dto) {
        this.name = dto.getName();
        this.group = dto.getGroup();
        this.term = dto.getTerm();
        this.campus = dto.getCampus();
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}

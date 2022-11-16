package kr.co.godingeo.domain.user.domain;

import kr.co.godingeo.global.entity.BaseEntity;
import kr.co.godingeo.global.enums.UserRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 45)
    private String accountId;

    @NotNull
    @Size(max = 60)
    private String password;

    @NotNull
    @Size(max = 11)
    private String name;

    @NotNull
    @Size(max = 11)
    private String job;

    @Column
    private Integer grade;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private UserRole role;

    @Builder
    public User(String accountId, String password, String name, String job, Integer grade, UserRole role) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.job = job;
        this.grade = grade;
        this.role = role;
    }
    
}
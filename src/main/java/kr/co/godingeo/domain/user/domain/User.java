package kr.co.godingeo.domain.user.domain;

import kr.co.godingeo.domain.user.presentation.dto.request.UpdateUserInfoRequest;
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
public class User {

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

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private UserRole role;

    @Builder
    public User(String accountId, String password, String name, String job, UserRole role) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.job = job;
        this.role = role;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void updateUser(UpdateUserInfoRequest request) {
        this.name = request.getName();
        this.job = request.getJob();
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
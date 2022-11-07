package kr.co.godingeo.domain.auth.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class RefreshToken {

    @Id
    private String accountId;

    @NotNull
    private String token;

    @NotNull
    private Long timeToLive;

    @NotNull
    private Long userId;

    @Builder
    public RefreshToken(String accountId, String token, Long timeToLive, Long userId) {
        this.accountId = accountId;
        this.token = token;
        this.timeToLive = timeToLive;
        this.userId = userId;
    }

    public RefreshToken updateToken(String token, Long timeToLive, Long userId) {
        this.token = token;
        this.timeToLive = timeToLive;
        this.userId = userId;
        return this;
    }

}

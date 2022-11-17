package kr.co.godingeo.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserInfoResponse {
    private final String accountId;
    private final String name;
    private final String job;
}

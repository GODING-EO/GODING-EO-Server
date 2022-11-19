package kr.co.godingeo.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserProfileResponse {
    private final String name;
    private final String job;
}

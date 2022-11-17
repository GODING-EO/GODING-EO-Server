package kr.co.godingeo.domain.user.service;

import kr.co.godingeo.domain.user.domain.User;
import kr.co.godingeo.domain.user.presentation.dto.response.QueryUserInfoResponse;
import kr.co.godingeo.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryUserProfileService {

    private final UserUtil userUtil;

    public QueryUserInfoResponse execute(Long userId) {
        User user = userUtil.getUserById(userId);

        return QueryUserInfoResponse.builder()
                .name(user.getName())
                .job(user.getJob())
                .build();
    }
}

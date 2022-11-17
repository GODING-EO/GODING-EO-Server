package kr.co.godingeo.domain.user.service;

import kr.co.godingeo.domain.user.domain.User;
import kr.co.godingeo.domain.user.presentation.dto.response.QueryUserInfoResponse;
import kr.co.godingeo.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMypageService {

    private final UserUtil userUtil;

    @Transactional
    public QueryUserInfoResponse execute() {
        User user = userUtil.getCurrentUser();

        return QueryUserInfoResponse.builder()
                .accountId(user.getAccountId())
                .name(user.getName())
                .job(user.getJob())
                .build();
    }
}

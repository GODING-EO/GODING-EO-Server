package kr.co.godingeo.domain.auth.service;

import kr.co.godingeo.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckAccountIdExistsService {

    private final UserUtil userUtil;

    public void execute(String accountId) {
        userUtil.checkUserExists(accountId);
    }

}

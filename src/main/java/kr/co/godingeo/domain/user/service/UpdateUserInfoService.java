package kr.co.godingeo.domain.user.service;

import kr.co.godingeo.domain.user.domain.User;
import kr.co.godingeo.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import kr.co.godingeo.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInfoService {

    private final UserUtil userUtil;

    @Transactional
    public void execute(UpdateUserInfoRequest request) {
        User user = userUtil.getCurrentUser();
        user.updateUser(request);

    }
}

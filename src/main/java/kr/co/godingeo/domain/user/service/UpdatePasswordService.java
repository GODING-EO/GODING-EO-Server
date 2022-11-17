package kr.co.godingeo.domain.user.service;

import kr.co.godingeo.domain.auth.exception.PasswordMisMatchException;
import kr.co.godingeo.domain.user.domain.User;
import kr.co.godingeo.domain.user.presentation.dto.request.UpdatePasswordRequest;
import kr.co.godingeo.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UpdatePasswordService {

    private final UserUtil userUtil;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UpdatePasswordRequest request) {
        User user = userUtil.getCurrentUser();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
    }
}

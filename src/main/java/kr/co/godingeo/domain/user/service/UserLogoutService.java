package kr.co.godingeo.domain.user.service;

import kr.co.godingeo.domain.auth.domain.RefreshToken;
import kr.co.godingeo.domain.auth.domain.repository.RefreshTokenRepository;
import kr.co.godingeo.domain.auth.exception.RefreshTokenNotFoundException;
import kr.co.godingeo.domain.user.domain.User;
import kr.co.godingeo.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserLogoutService {
    
    private final UserUtil userUtil;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute() {
        User user = userUtil.getCurrentUser();

        RefreshToken refreshToken = refreshTokenRepository.findById(user.getAccountId())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }
}

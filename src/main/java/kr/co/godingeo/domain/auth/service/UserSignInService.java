package kr.co.godingeo.domain.auth.service;

import kr.co.godingeo.domain.auth.exception.PasswordMisMatchException;
import kr.co.godingeo.domain.auth.presentation.dto.request.UserSignInRequest;
import kr.co.godingeo.domain.auth.presentation.dto.response.UserTokenResponse;
import kr.co.godingeo.domain.user.domain.User;
import kr.co.godingeo.domain.user.domain.repository.UserRepository;
import kr.co.godingeo.global.exception.UserNotFoundException;
import kr.co.godingeo.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignInService {


    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserTokenResponse execute(UserSignInRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(user.getAccountId(), user.getId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getAccountId(), user.getId());

        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(jwtTokenProvider.getExpiredTime())
                .refreshToken(refreshToken)
                .build();
    }
}

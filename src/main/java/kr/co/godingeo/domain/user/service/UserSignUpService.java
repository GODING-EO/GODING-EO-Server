package kr.co.godingeo.domain.user.service;

import kr.co.godingeo.domain.auth.presentation.dto.response.UserTokenResponse;
import kr.co.godingeo.domain.user.domain.User;
import kr.co.godingeo.domain.user.domain.repository.UserRepository;
import kr.co.godingeo.domain.user.util.UserUtil;
import kr.co.godingeo.domain.user.presentation.dto.request.UserSignUpRequest;
import kr.co.godingeo.global.enums.UserRole;
import kr.co.godingeo.global.property.jwt.JwtProperties;
import kr.co.godingeo.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserUtil userUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public UserTokenResponse execute(UserSignUpRequest request) {
        userUtil.checkUserExists(request.getAccountId());

        User user = userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .job(request.getJob())
                .role(UserRole.USER)
                .build());

        String accessToken = jwtTokenProvider.generateAccessToken(user.getAccountId(), user.getId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getAccountId(), user.getId());

        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(ZonedDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(refreshToken)
                .build();
    }
}

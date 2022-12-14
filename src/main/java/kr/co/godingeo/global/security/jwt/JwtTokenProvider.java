package kr.co.godingeo.global.security.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.co.godingeo.domain.auth.domain.RefreshToken;
import kr.co.godingeo.domain.auth.domain.repository.RefreshTokenRepository;
import kr.co.godingeo.global.enums.UserRole;
import kr.co.godingeo.global.exception.ExpiredJwtException;
import kr.co.godingeo.global.exception.InvalidJwtException;
import kr.co.godingeo.global.property.jwt.JwtProperties;
import kr.co.godingeo.global.security.auth.AuthDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer";

    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    public String generateAccessToken(String id, Long userId) {
        return generateToken(id, "access", jwtProperties.getAccessExp(), userId);
    }

    public String generateRefreshToken(String id, Long userId) {
        String refreshToken = generateToken(id, "refresh", jwtProperties.getRefreshExp(), userId);
        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(id)
                .token(refreshToken)
                .userId(userId)
                .timeToLive(jwtProperties.getRefreshExp())
                .build());

        return refreshToken;
    }

    private String generateToken(String id, String type, Long exp, Long userId) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(id)
                .setHeaderParam("type", type)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(HEADER);
        return parseToken(bearer);
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService
                .loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(PREFIX))
            return bearerToken.replace(PREFIX, "");
        return null;
    }

    public ZonedDateTime getExpiredTime() {
        return ZonedDateTime.now().plusSeconds(jwtProperties.getAccessExp());
    }

    private Claims getTokenBody(String token) {

        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw ExpiredJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwtException.EXCEPTION;
        }
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

}
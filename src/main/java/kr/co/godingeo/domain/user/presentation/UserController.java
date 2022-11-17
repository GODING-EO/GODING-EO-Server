package kr.co.godingeo.domain.user.presentation;

import kr.co.godingeo.domain.auth.presentation.dto.response.UserTokenResponse;
import kr.co.godingeo.domain.user.presentation.dto.request.UpdatePasswordRequest;
import kr.co.godingeo.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import kr.co.godingeo.domain.user.presentation.dto.request.UserSignUpRequest;
import kr.co.godingeo.domain.user.presentation.dto.response.QueryUserInfoResponse;
import kr.co.godingeo.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserLogoutService userLogoutService;
    private final UserWithdrawalService userWithdrawalService;
    private final QueryMyInfoService queryMyInfoService;
    private final QueryUserProfileService queryUserProfileService;
    private final QueryMypageService queryMypageService;
    private final UpdateUserInfoService updateUserInfoService;
    private final UpdatePasswordService updatePasswordService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserTokenResponse userSignUp(@RequestBody @Valid UserSignUpRequest request) {
        return userSignUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        userLogoutService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/leave")
    public void leave() {
        userWithdrawalService.execute();
    }

    @GetMapping
    public QueryUserInfoResponse queryMyPage() {
        return queryMypageService.execute();
    }

    @GetMapping("/{user-id}")
    public QueryUserInfoResponse queryUserProfile(@PathVariable("user-id") Long userId) {
        return queryUserProfileService.execute(userId);
    }

    @GetMapping("/info")
    public QueryUserInfoResponse queryMyInfo() {
        return queryMyInfoService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping
    public void updateUserInfo(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void updatePassword(@RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordService.execute(request);
    }
}

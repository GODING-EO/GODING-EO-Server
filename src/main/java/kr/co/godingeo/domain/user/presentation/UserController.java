package kr.co.godingeo.domain.user.presentation;

import io.swagger.annotations.ApiOperation;
import kr.co.godingeo.domain.auth.presentation.dto.response.UserTokenResponse;
import kr.co.godingeo.domain.user.presentation.dto.request.UpdatePasswordRequest;
import kr.co.godingeo.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import kr.co.godingeo.domain.user.presentation.dto.request.UserSignUpRequest;
import kr.co.godingeo.domain.user.presentation.dto.response.QueryUserInfoResponse;
import kr.co.godingeo.domain.user.presentation.dto.response.QueryUserProfileResponse;
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


    @ApiOperation(value = "회원가입")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserTokenResponse userSignUp(@RequestBody @Valid UserSignUpRequest request) {
        return userSignUpService.execute(request);
    }


    @ApiOperation(value = "로그아웃")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        userLogoutService.execute();
    }


    @ApiOperation(value = "회원탈퇴")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/leave")
    public void leave() {
        userWithdrawalService.execute();
    }


    @ApiOperation(value = "마이 페이지 보기")
    @GetMapping
    public QueryUserInfoResponse queryMyPage() {
        return queryMypageService.execute();
    }


    @ApiOperation(value = "다른 유저 정보 가져오기")
    @GetMapping("/{user-id}")
    public QueryUserProfileResponse queryUserProfile(@PathVariable("user-id") Long userId) {
        return queryUserProfileService.execute(userId);
    }


    @ApiOperation(value = "내 정보 수정 페이지 방문하기")
    @GetMapping("/info")
    public QueryUserInfoResponse queryMyInfo() {
        return queryMyInfoService.execute();
    }


    @ApiOperation(value = "내 정보 수정하기")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping
    public void updateUserInfo(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }


    @ApiOperation(value = "비밀번호 바꾸기")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void updatePassword(@RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordService.execute(request);
    }
}

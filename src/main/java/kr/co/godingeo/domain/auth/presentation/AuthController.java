package kr.co.godingeo.domain.auth.presentation;


import io.swagger.annotations.ApiOperation;
import kr.co.godingeo.domain.auth.presentation.dto.request.UserSignInRequest;
import kr.co.godingeo.domain.auth.presentation.dto.response.UserTokenResponse;
import kr.co.godingeo.domain.auth.service.CheckAccountIdExistsService;
import kr.co.godingeo.domain.auth.service.UserSignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class AuthController {

    private final UserSignInService userSignInService;
    private final CheckAccountIdExistsService checkAccountIdExistsService;

    @ApiOperation(value = "로그인")
    @PostMapping("/token")
    public UserTokenResponse userSignIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }


    @ApiOperation(value = "아이디 중복 체크")
    @RequestMapping(value = "/account-id", method = RequestMethod.HEAD)
    public void checkAccountIdExists(@NotBlank @RequestParam(name = "accountId") String accountId) {
        checkAccountIdExistsService.execute(accountId);
    }
}

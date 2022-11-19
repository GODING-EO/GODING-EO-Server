package kr.co.godingeo.domain.auth.presentation;


import io.swagger.annotations.ApiOperation;
import kr.co.godingeo.domain.auth.presentation.dto.request.UserSignInRequest;
import kr.co.godingeo.domain.auth.presentation.dto.response.UserTokenResponse;
import kr.co.godingeo.domain.auth.service.CheckUserNameExistsService;
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
    private final CheckUserNameExistsService checkUserNameExistsService;

    @ApiOperation(value = "로그인")
    @PostMapping("/token")
    public UserTokenResponse userSignIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }


    @ApiOperation(value = "이름 중복 체크")
    @RequestMapping(value = "/name", method = RequestMethod.HEAD)
    public void checkNicknameExist(@NotBlank @RequestParam(name = "name") String name) {
        checkUserNameExistsService.execute(name);
    }
}

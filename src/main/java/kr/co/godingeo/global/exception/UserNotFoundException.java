package kr.co.godingeo.global.exception;

import kr.co.godingeo.global.error.exception.GlobalErrorCode;
import kr.co.godingeo.global.error.exception.GodingeoException;

public class UserNotFoundException extends GodingeoException {

    public static final GodingeoException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(GlobalErrorCode.USER_NOT_FOUND);
    }
}

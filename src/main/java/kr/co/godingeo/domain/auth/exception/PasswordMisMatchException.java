package kr.co.godingeo.domain.auth.exception;

import kr.co.godingeo.global.error.exception.GlobalErrorCode;
import kr.co.godingeo.global.error.exception.GodingeoException;

public class PasswordMisMatchException extends GodingeoException{

    public static final GodingeoException EXCEPTION =
            new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(GlobalErrorCode.PASSWORD_MISMATCH);
    }
}

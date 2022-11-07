package kr.co.godingeo.global.exception;

import kr.co.godingeo.global.error.exception.GlobalErrorCode;
import kr.co.godingeo.global.error.exception.GodingeoException;

public class InvalidJwtException extends GodingeoException {

    public static final GodingeoException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(GlobalErrorCode.INVALID_JWT);
    }
}

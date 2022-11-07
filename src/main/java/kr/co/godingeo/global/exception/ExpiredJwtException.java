package kr.co.godingeo.global.exception;

import kr.co.godingeo.global.error.exception.GlobalErrorCode;
import kr.co.godingeo.global.error.exception.GodingeoException;

public class ExpiredJwtException extends GodingeoException {

    public static final GodingeoException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(GlobalErrorCode.EXPIRED_JWT);
    }
}

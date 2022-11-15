package kr.co.godingeo.domain.user.exception;

import kr.co.godingeo.global.error.exception.GlobalErrorCode;
import kr.co.godingeo.global.error.exception.GodingeoException;

public class AlreadyUserExistException extends GodingeoException {

    public static final GodingeoException EXCEPTION =
            new AlreadyUserExistException();

    private AlreadyUserExistException() {
        super(GlobalErrorCode.ALREADY_USER_EXIST);
    }
}

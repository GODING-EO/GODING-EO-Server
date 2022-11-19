package kr.co.godingeo.domain.user.exception;

import kr.co.godingeo.global.error.exception.GlobalErrorCode;
import kr.co.godingeo.global.error.exception.GodingeoException;

public class AlreadyUserNameExistException extends GodingeoException {

    public static final GodingeoException EXCEPTION =
            new AlreadyUserNameExistException();

    private AlreadyUserNameExistException() {
        super(GlobalErrorCode.ALREADY_USER_NAME_EXIST);
    }
}

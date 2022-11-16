package kr.co.godingeo.domain.school.exception;

import kr.co.godingeo.global.error.exception.GlobalErrorCode;
import kr.co.godingeo.global.error.exception.GodingeoException;

public class SchoolNotFoundException extends GodingeoException {

    public static final GodingeoException EXCEPTION =
            new SchoolNotFoundException();

    private SchoolNotFoundException() {
        super(GlobalErrorCode.SCHOOL_NOT_FOUND);
    }
}

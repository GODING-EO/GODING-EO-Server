package kr.co.godingeo.domain.school.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuerySchoolResponse {

    private final List<SchoolInformation> school;

    @Getter
    @AllArgsConstructor
    public static class SchoolInformation {
        private final String code;
        private final String name;
        private final String type;
        private final String location;
        private final String adress;
        private final String phone;
        private final String url;
        private final String division;
    }

}

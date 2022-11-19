package kr.co.godingeo.domain.school.presentation;

import io.swagger.annotations.ApiOperation;
import kr.co.godingeo.domain.school.presentation.dto.response.QuerySchoolResponse;
import kr.co.godingeo.domain.school.service.QuerySchoolDivisionService;
import kr.co.godingeo.domain.school.service.QuerySchoolNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final QuerySchoolNameService querySchoolNameService;
    private final QuerySchoolDivisionService querySchoolDivisionService;


    @ApiOperation(value = "이름으로 학교 찾기")
    @GetMapping("/name")
    public QuerySchoolResponse querySchoolName(@RequestParam("where") String name) {
        return querySchoolNameService.execute(name);
    }

    @ApiOperation(value = "학교 종류로 학교 찾기[일반고, 특목고, 특성화고, 자율고]")
    @GetMapping("/division")
    public QuerySchoolResponse querySchoolDivision(@RequestParam("where") String division) {
        return querySchoolDivisionService.execute(division);
    }
}

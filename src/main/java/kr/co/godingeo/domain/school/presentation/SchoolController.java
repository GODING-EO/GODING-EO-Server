package kr.co.godingeo.domain.school.presentation;

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

    @GetMapping("/name")
    public QuerySchoolResponse querySchoolName(@RequestParam("where") String name) {
        return querySchoolNameService.execute(name);
    }

    @GetMapping("/division")
    public QuerySchoolResponse querySchoolDivision(@RequestParam("where") String division) {
        return querySchoolDivisionService.execute(division);
    }
}

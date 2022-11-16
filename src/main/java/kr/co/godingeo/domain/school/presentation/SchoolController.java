package kr.co.godingeo.domain.school.presentation;

import kr.co.godingeo.domain.school.presentation.dto.response.QuerySchoolResponse;
import kr.co.godingeo.domain.school.service.BookmarkSchoolService;
import kr.co.godingeo.domain.school.service.QuerySchoolDivisionService;
import kr.co.godingeo.domain.school.service.QuerySchoolNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final QuerySchoolNameService querySchoolNameService;
    private final QuerySchoolDivisionService querySchoolDivisionService;
    private final BookmarkSchoolService bookmarkSchoolService;

    @GetMapping("/name")
    public QuerySchoolResponse querySchoolName(@RequestParam("name") String name,
                                           Pageable pageable) {
        return querySchoolNameService.execute(name, pageable);
    }

    @GetMapping("/division")
    public QuerySchoolResponse querySchoolDivision(@RequestParam("division") String division,
                                                   Pageable pageable) {
        return querySchoolDivisionService.execute(division, pageable);
    }

    @PostMapping("/bookmark/{schoolCode}")
    public boolean bookmark(@PathVariable String schoolCode) {
        return bookmarkSchoolService.execute(schoolCode);
    }
}

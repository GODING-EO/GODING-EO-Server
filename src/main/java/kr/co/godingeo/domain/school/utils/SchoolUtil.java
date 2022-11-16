package kr.co.godingeo.domain.school.utils;

import kr.co.godingeo.domain.school.domain.School;
import kr.co.godingeo.domain.school.domain.repository.SchoolRepository;
import kr.co.godingeo.domain.school.exception.SchoolNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SchoolUtil {

    private final SchoolRepository schoolRepository;

    public School getSchoolByCode(String code) {
        return schoolRepository.findById(code)
                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);
    }

    public List<School> getSchoolByName(String name) {
        return schoolRepository.findByNameContaining(name);
    }

    public List<School> getSchoolByDivision(String division) {
        return schoolRepository.findByDivisionContaining(division);
    }

}

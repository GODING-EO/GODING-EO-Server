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

    public Page<School> getSchoolByName(String name, Pageable pageable) {
        return schoolRepository.findByNameContaining(name, pageable);
    }

    public Page<School> getSchoolByDivision(String division, Pageable pageable) {
        return schoolRepository.findByDivisionContaining(division, pageable);
    }

}

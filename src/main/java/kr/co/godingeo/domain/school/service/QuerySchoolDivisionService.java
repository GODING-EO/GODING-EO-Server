package kr.co.godingeo.domain.school.service;

import kr.co.godingeo.domain.school.presentation.dto.response.QuerySchoolResponse;
import kr.co.godingeo.domain.school.utils.SchoolUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuerySchoolDivisionService {

    private final SchoolUtil schoolUtil;

    @Transactional
    public QuerySchoolResponse execute(String division) {
        return new QuerySchoolResponse(schoolUtil.getSchoolByDivision(division)
                .stream()
                .map(school -> new QuerySchoolResponse.SchoolInformation(school.getId(), school.getName(),
                        school.getType(), school.getLocation(), school.getAdress(),
                        school.getPhone(), school.getUrl(), school.getDivision(), school.getImageUrl()))
                .collect(Collectors.toList()));
    }
}

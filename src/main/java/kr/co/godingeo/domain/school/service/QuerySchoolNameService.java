package kr.co.godingeo.domain.school.service;

import kr.co.godingeo.domain.school.utils.SchoolUtil;
import kr.co.godingeo.domain.school.presentation.dto.response.QuerySchoolResponse;
import kr.co.godingeo.domain.school.presentation.dto.response.QuerySchoolResponse.SchoolInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuerySchoolNameService {

    private final SchoolUtil schoolUtil;

    @Transactional
    public QuerySchoolResponse execute(String name) {
        return new QuerySchoolResponse(schoolUtil.getSchoolByName(name)
                .stream()
                .map(school -> new SchoolInformation(school.getCode(), school.getName(),
                        school.getType(), school.getLocation(), school.getAdress(),
                        school.getPhone(), school.getUrl(), school.getDivision()))
                .collect(Collectors.toList()));
    }

}

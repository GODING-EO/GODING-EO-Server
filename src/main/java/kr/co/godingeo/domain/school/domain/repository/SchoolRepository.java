package kr.co.godingeo.domain.school.domain.repository;

import kr.co.godingeo.domain.school.domain.School;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolRepository extends CrudRepository<School, String> {

    Optional<School> findByCode(String code);
    Page<School> findByNameContaining(String name, Pageable pageable);

    Page<School> findByDivisionContaining(String division, Pageable pageable);
}

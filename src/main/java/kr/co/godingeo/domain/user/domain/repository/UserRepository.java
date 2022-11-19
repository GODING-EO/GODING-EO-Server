package kr.co.godingeo.domain.user.domain.repository;

import kr.co.godingeo.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);
    Optional<User> findByName(String name);
}

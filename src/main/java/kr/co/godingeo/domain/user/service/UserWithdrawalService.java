package kr.co.godingeo.domain.user.service;

import kr.co.godingeo.domain.user.domain.User;
import kr.co.godingeo.domain.user.domain.repository.UserRepository;
import kr.co.godingeo.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserWithdrawalService {

    private UserUtil userUtil;
    private UserRepository userRepository;

    @Transactional
    public void execute() {
        User user = userUtil.getCurrentUser();

        userRepository.delete(user);

    }
}

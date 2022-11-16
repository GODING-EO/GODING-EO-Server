//package kr.co.godingeo.domain.school.service;
//
//import kr.co.godingeo.domain.school.domain.BookmarkSchool;
//import kr.co.godingeo.domain.school.domain.School;
//import kr.co.godingeo.domain.school.domain.repository.BookmarkSchoolRepository;
//import kr.co.godingeo.domain.school.domain.repository.SchoolRepository;
//import kr.co.godingeo.domain.school.exception.SchoolNotFoundException;
//import kr.co.godingeo.domain.user.domain.User;
//import kr.co.godingeo.domain.user.util.UserUtil;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class BookmarkSchoolService {
//
//    private final UserUtil userUtil;
//    private final SchoolRepository schoolRepository;
//    private final BookmarkSchoolRepository bookmarkSchoolRepository;
//
//    @Transactional
//    public boolean execute(String code) {
//
//        User user = userUtil.getCurrentUser();
//
//        School school = schoolRepository.findByCode(code)
//                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);
//
//        Optional<BookmarkSchool> existsBookmarkSchool = bookmarkSchoolRepository.findBySchoolAndUser(school, user);
//
//        if (existsBookmarkSchool.isPresent()) {
//            bookmarkSchoolRepository.delete(existsBookmarkSchool.get());
//            return false;
//        } else {
//            BookmarkSchool bookmarkSchool = BookmarkSchool.createBookmarkSchool(user, school);
//            bookmarkSchoolRepository.save(bookmarkSchool);
//            return true;
//        }
//    }
//}

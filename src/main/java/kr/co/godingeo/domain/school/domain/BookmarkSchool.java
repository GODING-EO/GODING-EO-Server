//package kr.co.godingeo.domain.school.domain;
//
//import kr.co.godingeo.domain.user.domain.User;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@NoArgsConstructor
//@Entity
//@Table(name = "bookmark_school")
//public class BookmarkSchool {
//
//    @EmbeddedId
//    private BookmarkSchoolId bookmarkSchoolId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "school_code")
//    @MapsId("schoolCode")
//    private School school;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    @MapsId("userId")
//    private User user;
//
//    public static BookmarkSchool createBookmarkSchool(User user, School school) {
//        BookmarkSchool bookmarkSchool = new BookmarkSchool();
//        bookmarkSchool.bookmarkSchoolId = new BookmarkSchoolId(user.getId(), school.getCode());
//        bookmarkSchool.user = user;
//        bookmarkSchool.school = school;
//        return bookmarkSchool;
//    }
//}

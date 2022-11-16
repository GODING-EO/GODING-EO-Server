package kr.co.godingeo.domain.school.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "school")
public class School {

    @Id
    @Column(length = 7, nullable = false)
    private String code;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String type;

    @Column(length = 30, nullable = false)
    private String location;

    @Column(length = 200, nullable = false)
    private String adress;

    @Column(length = 13, nullable = false)
    private String phone;

    @Column(nullable = false)
    private String url;

    @Column(length = 50, nullable = false)
    private String division;

}

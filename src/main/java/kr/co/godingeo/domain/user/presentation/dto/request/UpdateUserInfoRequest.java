package kr.co.godingeo.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    @NotBlank(message = "name은 null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 1, max = 11, message = "name은 1글자와 11글자 사이여야 합니다.")
    private String name;

    @NotBlank(message = "job은 null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String job;

}

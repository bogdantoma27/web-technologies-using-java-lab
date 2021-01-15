package com.unibuc.airlinebooking.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private Long id;
    private String cnp;
    private Integer age;
    private String otherInformation;

}

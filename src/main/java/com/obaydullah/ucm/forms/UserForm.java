package com.obaydullah.ucm.forms;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String about;

}

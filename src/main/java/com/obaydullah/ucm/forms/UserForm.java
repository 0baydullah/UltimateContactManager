package com.obaydullah.ucm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Name is Required!")
    @Size(min = 3, message = "Minimum 3 Characters is Required!")
    private String name;

    @NotBlank(message = "Password is Required!")
    @Size(min = 6, message = "Minimum 6 Characters is Required!")
    private String password;


    @NotBlank(message = "Email is Required!")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" ,message = "Enter valid Email!")
    private String email;

   // @Pattern(regexp = "^(\\\\d{3}[- .]?){2}\\\\d{4}$" , message = "Input Should Contains Valid Phone Number")
    @Size(message = "Invalid Phone Number!" , min = 8, max = 15)
    private String phoneNumber;

    @NotBlank(message = "About is Required!")
    private String about;

}

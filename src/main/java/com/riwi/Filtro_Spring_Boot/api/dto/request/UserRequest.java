package com.riwi.Filtro_Spring_Boot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "El nombre es requerido")
    @Size( max = 100, message = "El nombre no puede tener mas de 100 caracteres")
    private String userName;

    @NotBlank(message = "El correo es requerido")
    @Email(message = "el correo debe de ser escrito asi: [Ejemplo@ejemplo.com]")
    private String email;

    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
    @Pattern(
        regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$).{8,20}$",
            message = "La contraseña debe contener al menos un dígito, una letra minúscula, una letra mayúscula, un carácter especial y ningún espacio en blanco."
    )
    private String password;

    private boolean active;
}

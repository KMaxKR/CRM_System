package crm.ks.CRM.io;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
public class ProfileRequest {

    @NotBlank(message = "Username must not be empty")
    private String username;

    @NotNull
    @Email(message = "Enter valid email")
    private String email;

    @Min(value = 6, message = "Password must be atleast 6 characters ")
    private String password;
}

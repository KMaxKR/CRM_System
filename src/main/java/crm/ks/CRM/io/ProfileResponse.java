package crm.ks.CRM.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResponse {
    private String unique_code;
    private String username;
    private String email;
    private Boolean isAccountVerified;
}

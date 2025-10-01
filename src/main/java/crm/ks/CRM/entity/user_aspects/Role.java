package crm.ks.CRM.entity.user_aspects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    USER("USER"),
    ADMIN("ADMIN"),
    ROOT("ROOT");

    @Getter
    public final String role;
}

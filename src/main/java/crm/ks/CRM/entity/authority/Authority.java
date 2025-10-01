package crm.ks.CRM.entity.authority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Authority {
    USER("USER"),
    ADMIN("ADMIN"),
    ROOT("ROOT");

    @Getter
    public final String role;
}

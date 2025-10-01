package crm.ks.CRM.entity.authority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AuthorityType {
    GET("GET"),
    POST("POST"),
    DELETE("DELETE"),
    UPDATE("UPDATE");

    @Getter
    public final String authority_type;
}

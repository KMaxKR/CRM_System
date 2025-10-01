package crm.ks.CRM.entity.provider;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Provider {
    LOCAL("LOCAL"),
    OAUTH("OAUTH");

    @Getter
    public final String provider;
}

package crm.ks.CRM.entity;

import crm.ks.CRM.entity.authority.Authority;
import crm.ks.CRM.entity.authority.AuthorityType;
import crm.ks.CRM.entity.provider.Provider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "crm_user_data")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Column(name = "authority_type")
    @Enumerated(EnumType.STRING)
    private AuthorityType authority_type;

    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    private Provider provider;

    //TODO on other server side image storage
    @Column(name = "img_url")
    private String img_url;

    @Column(name = "isEnable")
    private Boolean isEnable;

    @Column(name = "last_login")
    private Date last_login;

    /*
        unique code for all users -> #xxxx
        Code format     -> #
        Authority level -> 1
        AuthorityType   -> 1
        Digits          -> 0
        Digits          -> 0
        Output          -> #1100
     */
    @Column(name = "unique_code")
    private String unique_code;

    @Column(name = "verificated")
    private Boolean verificated;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(authority.getAuthority()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnable;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnable;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnable;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }
}

package crm.ks.CRM.entity;

import crm.ks.CRM.entity.authority.Authority;
import crm.ks.CRM.entity.provider.Provider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "crm_user_data")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails {

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

    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    private Provider provider;

    //TODO on other server side image storage
    @Column(name = "img_url")
    private String img_url;

    @Column(name = "isEnable")
    private Boolean isEnable;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    @Column(name = "last_login")
    private Date last_login;

    /*
        unique code for all users -> #xxxx
        Code format     -> #
        Authority level -> 1
        Digits          -> 0
        Digits          -> 0
        Digits          -> 1
        Output          -> #1001
     */
    @Column(name = "unique_code")
    private String unique_code;

    @Column(name = "verified")
    private Boolean verified;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(authority.getAuthority()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnable && verified;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnable && verified;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnable && verified;
    }

    @Override
    public boolean isEnabled() {
        return isEnable && verified;
    }
}

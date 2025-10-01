package crm.ks.CRM.entity;

import crm.ks.CRM.entity.authority.Authority;
import crm.ks.CRM.entity.authority.AuthorityType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "crm_user_data")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    private Authority role;

    @Column(name = "authority_type")
    @Enumerated(EnumType.STRING)
    private AuthorityType authority_type;

    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    private String provider;

    //TODO on other server side image storage
    @Column(name = "img_url")
    private String img_url;

    @Column(name = "")
}

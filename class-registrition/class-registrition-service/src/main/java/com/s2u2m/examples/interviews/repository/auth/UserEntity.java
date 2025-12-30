package com.s2u2m.examples.interviews.repository.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;

@Entity
@Data
public class UserEntity implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  // TODO: set unique constraint
  private String username;
  private String password;

//  @OneToMany(mappedBy = "user")
//  private List<RoleEntity> roles;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO: use user role entity instead
    List<RoleEntity> roles = Collections.emptyList();
    if (ObjectUtils.isEmpty(roles)) {
      return Collections.emptyList();
    }

    return roles.stream()
        .map(role -> new SimpleGrantedAuthority("Role_" + role.getName()))
        .collect(Collectors.toList());
  }
}

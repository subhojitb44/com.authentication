package org.authentication.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.authentication.enums.AvailabilityStateEnum;
import org.authentication.enums.RoleEnum;
import org.authentication.repositories.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "app_user")
public class AppUser implements UserDetails {

    @Id
    private String ccId;

    private String username;

    private String password;

    private String name;

    private String phone;

    private String cin;

    private AvailabilityStateEnum status;

    private List<RoleEnum> role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .toList();
    }

    // Implement UserDetails methods

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Transient
    @Autowired
    private SequenceRepository sequenceRepository;

    public AppUser(String name,String username) {
        this.ccId = generateId(name,username);
    }

    private String generateId(String name,String username) {
        String prefix = name.substring(0, Math.min(name.length(), 3)).toUpperCase();
        Sequence sequence = sequenceRepository.findByName(username);
        long nextValue = sequence != null ? sequence.getValue() + 1 : 1;
        sequence.setName(username);
        sequence.setValue(nextValue);
        sequenceRepository.save(sequence); // Save the updated sequence
        return prefix + String.format("%05d", nextValue);
    }
}

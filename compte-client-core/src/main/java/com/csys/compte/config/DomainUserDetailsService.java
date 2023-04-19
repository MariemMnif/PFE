package com.csys.compte.config;


import com.csys.compte.domain.Utilisateur;
import com.csys.compte.repository.UtilisateurRepository;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final UtilisateurRepository utilisateurRepository;

    public DomainUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
// PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
//        final User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
log.error("Authenticating {}", login);  
        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        Optional<Utilisateur> userFromDatabase = utilisateurRepository
                .findOneByUserName(lowercaseLogin);

        return userFromDatabase.map(user -> {
                   String mdpe = new BCryptPasswordEncoder().encode(user.getPassword().toLowerCase(Locale.ENGLISH));
  List<GrantedAuthority> grantedAuthorities = java.util.Arrays.asList(new SimpleGrantedAuthority("compte-client-core"));
            return new org.springframework.security.core.userdetails.User(lowercaseLogin,"{bcrypt}"+mdpe,
                    grantedAuthorities);
        }).orElseThrow(
                () -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the " + "database"));
    }
}

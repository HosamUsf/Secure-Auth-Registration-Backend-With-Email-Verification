package com.hossam.login_tutorial.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository user ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.user.findByEmail(username)
                .map(UserAdapter::new).orElseThrow(() ->  new UsernameNotFoundException("User not found"));
    }


    private static class UserAdapter extends User implements UserDetails{
        private UserAdapter(User user){
            super(user);
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            SimpleGrantedAuthority  authority =
                    new SimpleGrantedAuthority(getUserRole().name());
            return Collections.singletonList(authority);
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return !getLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return getEnabled();
        }
    }
}

package com.jay.service;

import com.jay.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> auths= AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_VIP1");

        if(userDAO.getByUsername(username) == null) {
            throw new UsernameNotFoundException("用戶不存在");
        }

        return new User(userDAO.getByUsername(username).getUsername(),new BCryptPasswordEncoder().encode(userDAO.getByUsername(username).getPassword()),auths);

    }
}

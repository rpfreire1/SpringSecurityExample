package com.gatinodev.springsecurity.service;


import com.gatinodev.springsecurity.dto.AuthLoginRequest;
import com.gatinodev.springsecurity.dto.AuthResponse;
import com.gatinodev.springsecurity.model.SecurityUser;
import com.gatinodev.springsecurity.repository.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityUserServiceImpl implements  UserDetailsService{
    @Autowired
    private SecurityUserRepository securityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser securityUser=securityUserRepository.findSecurityUserByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("El usuario "+username+" no existe. "));
        List<SimpleGrantedAuthority> authorityList=new ArrayList<>();
        securityUser.getRoles().forEach(role -> authorityList.add(
                new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));
        securityUser.getRoles().stream().flatMap(
                role -> role.getPermissions().stream()).forEach(
                        permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));
        return new User(securityUser.getUsername()
        ,securityUser.getPassword()
        ,securityUser.getIsEnabled()
        ,securityUser.getAccountNoExpired()
        ,securityUser.getCredentialNoExpired()
        ,securityUser.getAccountNoLocked()
        ,authorityList) {
        };
    }
    public AuthResponse loginUser(AuthLoginRequest authLoginRequest){
        String username= authLoginRequest.username();
        St
    }


}

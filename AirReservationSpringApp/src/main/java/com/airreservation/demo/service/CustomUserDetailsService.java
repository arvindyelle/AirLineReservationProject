package com.airreservation.demo.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.airreservation.demo.dao.UserDao;
import com.airreservation.demo.model.Role;
import com.airreservation.demo.model.User;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserDao userDao;

	public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userDao.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRole()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> set) {
		return set.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
}

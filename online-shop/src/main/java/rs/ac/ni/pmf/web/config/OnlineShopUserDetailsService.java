package rs.ac.ni.pmf.web.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.model.entity.UserEntity;
import rs.ac.ni.pmf.web.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class OnlineShopUserDetailsService implements UserDetailsService {

	private static final String ROLE_PREFIX = "ROLE_";

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		final UserEntity userEntity = userRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
		System.out.println("zitomir stigo ovde OVDE"+userEntity.getUserName() + " " + userEntity.getPassword());
		return new UserDetailsImpl(userEntity);
	}

	@RequiredArgsConstructor
	private final class UserDetailsImpl implements UserDetails {

		private static final long serialVersionUID = 1L;
		private final UserEntity user;
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return Arrays.asList(new SimpleGrantedAuthority(ROLE_PREFIX + "User"));
		}

		@Override
		public String getPassword() {
			return user.getPassword();
		}

		@Override
		public String getUsername() {
			return user.getUserName();
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
	
	}
	
	
}

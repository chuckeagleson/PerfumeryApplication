package ok.boutique.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;
import ok.boutique.entity.user.Admin;
import ok.boutique.entity.user.User;

@Data
public class RegistrationForm {
	
	private String username;
	private String password;

	
	public User toUser(PasswordEncoder passwordEncoder) {
		return new User(username, passwordEncoder.encode(password));
	}
	
	public Admin toAdmin(PasswordEncoder passwordEncoder) {
		return new Admin(username, passwordEncoder.encode(password));
	}
}

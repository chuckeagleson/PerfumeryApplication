package ok.boutique.dao;

import org.springframework.data.repository.CrudRepository;

import ok.boutique.entity.user.User;

public interface UserRepository  extends CrudRepository<User,Long>{
	
	User findByUsername(String username);

}

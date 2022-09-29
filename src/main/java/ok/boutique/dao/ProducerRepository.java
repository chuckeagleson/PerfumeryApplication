package ok.boutique.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ok.boutique.entity.Producer;

@Repository
public interface ProducerRepository extends CrudRepository<Producer,Integer> {
	
	 List<Producer> findByName(String name);

}

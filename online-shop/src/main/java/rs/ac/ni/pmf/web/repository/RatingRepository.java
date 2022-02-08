package rs.ac.ni.pmf.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rs.ac.ni.pmf.web.model.entity.RatingEntity;

@Repository
public interface RatingRepository extends CrudRepository<RatingEntity,Integer>{

	@Override
	List<RatingEntity> findAll();
}

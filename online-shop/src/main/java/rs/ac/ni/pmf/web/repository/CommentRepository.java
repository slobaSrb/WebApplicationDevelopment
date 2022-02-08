package rs.ac.ni.pmf.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rs.ac.ni.pmf.web.model.entity.CommentEntity;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity,Integer>{
	
	@Override
	List<CommentEntity> findAll();
}

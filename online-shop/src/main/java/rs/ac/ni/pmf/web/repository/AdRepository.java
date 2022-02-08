package rs.ac.ni.pmf.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rs.ac.ni.pmf.web.model.entity.AdEntity;

@Repository
public interface AdRepository extends CrudRepository<AdEntity,Integer>, JpaSpecificationExecutor<AdEntity> {

	@Override
	List<AdEntity> findAll();
}

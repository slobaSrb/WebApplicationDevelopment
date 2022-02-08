package rs.ac.ni.pmf.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rs.ac.ni.pmf.web.model.entity.PurchaseEntity;

@Repository
public interface PurchaseRepository extends CrudRepository<PurchaseEntity, Integer> {
	
	@Override
	List<PurchaseEntity> findAll();
}

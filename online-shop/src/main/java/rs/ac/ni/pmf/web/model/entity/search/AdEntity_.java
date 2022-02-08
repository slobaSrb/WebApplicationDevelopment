package rs.ac.ni.pmf.web.model.entity.search;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import rs.ac.ni.pmf.web.model.entity.AdEntity;
import rs.ac.ni.pmf.web.model.entity.UserEntity;

@StaticMetamodel(AdEntity.class)
public class AdEntity_ {

	public static volatile SingularAttribute<AdEntity, String> title;
	//public static volatile SingularAttribute<ProjectEntity, LocalDate> start_date;
	//public static volatile SingularAttribute<ProjectEntity, Status> status;
	
	public static volatile SingularAttribute<AdEntity, UserEntity> buyer;
}
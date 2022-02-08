package rs.ac.ni.pmf.web.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@Builder
//@Entity
//@Table(name="user_type")
//@NoArgsConstructor
//@AllArgsConstructor
//public class RolesOfUser {
//
//	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
//	private int roleID;
//	
//	private String roleName;
//	
//	
//	@OneToMany(
//		mappedBy = "roleID",
//		cascade = CascadeType.ALL,
//		orphanRemoval = true,
//		fetch = FetchType.LAZY)
//	private List<UserEntity> users;
//	
//}

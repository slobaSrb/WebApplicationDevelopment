package rs.ac.ni.pmf.web.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.ni.pmf.web.model.Roles;

@Data
@Builder
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserEntity {
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Integer userID;
	@Id
	private String userName;
	
	@Column(name = "full_name", nullable = true)
	private String fullName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "avg_rating", nullable = true)
	private Integer avgRating;

	@Column(name = "salt", nullable = false)
	private String salt;

//	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<AdEntity> ads;// = new ArrayList<>();
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "buyer")
	private List<PurchaseEntity> purchases = new ArrayList<>();
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<RatingEntity> ratings = new ArrayList<>();

	//@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userCommenter")
	private List<CommentEntity> comments;// = new <>();

	@Enumerated(EnumType.STRING)
	@Column(name = "role", columnDefinition = "varchar(255)", nullable = false)
	private Roles role;
	
	//@Column(name = "role", columnDefinition = "varchar(255) default 'test'", nullable = false)
	//	@Enumerated(EnumType.ORDINAL)
	//	private Roles role;
}


package rs.ac.ni.pmf.web.model.entity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.ni.pmf.web.model.AdStatus;
import rs.ac.ni.pmf.web.model.Currency;
import rs.ac.ni.pmf.web.model.DiscountType;

@Data
@Builder
@Entity
@Table(name = "ads")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class AdEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adID;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "price", nullable = false)
	private Double price;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "currency", nullable = false)
	private Currency currency;
	
	@Column(name = "ad_placement_date", nullable = false)
	private OffsetDateTime adPlacementDate;
//	
//	@Column(name = "buyer_id", columnDefinition = "int default 'test'", nullable = true)
//	private Integer buyerID;

	@Column(name = "category", nullable = true)
	private String category;

	@Column(name = "avg_rating", nullable = true)
	private Integer avgRating;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private AdStatus status;

	@Column(name = "quantity_available", nullable = false)
	private Integer quantityAvailable;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "discount_type", nullable = true)
	private DiscountType discountType;
	
	@Column(name = "discount_value", nullable = true)
	private Double discountValue;
	
	@Column(name = "discount_percentge", nullable = true)
	private Integer discountPercentage;
	
	@Column(name = "discount_validity", nullable = true)
	private OffsetDateTime discountValidity;
	
	@ManyToOne
	@JoinColumn(name = "user_name")
	private UserEntity user;
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ad")
	private List<PurchaseEntity> purchases = new ArrayList<>();
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ad")
	private List<CommentEntity> comments = new ArrayList<>();
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ad")
	private List<RatingEntity> ratings = new ArrayList<>();
}

package rs.ac.ni.pmf.web.model.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.ni.pmf.web.model.AdStatus;
import rs.ac.ni.pmf.web.model.Currency;
import rs.ac.ni.pmf.web.model.entity.AdEntity.AdEntityBuilder;

@Data
@Builder
@Entity
@Table(name = "purchases")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PurchaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseID;
	
	@ManyToOne
	@JoinColumn(name = "adID")
	private AdEntity ad;
	
	@ManyToOne
	@JoinColumn(name = "userName")
	private UserEntity buyer;
	
	@Column(name = "date_purchased", nullable = false)
	private OffsetDateTime datePurchased;
	
	@Column(name = "amount_purchesed", nullable = false)
	private int amountPurchesed;
	
	@Column(name = "total_value_of_purchase", nullable = false)
	private Double totalValueOfPurchase;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "currency", nullable = false)
	private Currency currency;
}

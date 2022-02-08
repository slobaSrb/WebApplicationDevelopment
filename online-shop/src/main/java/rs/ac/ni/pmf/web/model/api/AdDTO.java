package rs.ac.ni.pmf.web.model.api;

import java.time.OffsetDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import rs.ac.ni.pmf.web.model.DiscountType;
import rs.ac.ni.pmf.web.model.AdStatus;
import rs.ac.ni.pmf.web.model.Currency;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class AdDTO {
	private int adID;
	private String title;
	private String description;
	private double price;
	private Currency currency;
	private OffsetDateTime adPlacementDate;
//	private int purchaseID;
//	private Integer buyerID;
	private String category;
	private AdStatus status;
	private DiscountType discountType;
	private Double discountValue;
	private Integer discountPercentage;
	private OffsetDateTime discountValidity;
	private int quantityAvailable;
	private String userName;
}

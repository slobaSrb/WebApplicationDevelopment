package rs.ac.ni.pmf.web.model.api;

import java.time.OffsetDateTime;
import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import rs.ac.ni.pmf.web.model.Currency;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class PurchaseDTO {
	private int purchaseID;
	private int adID;
	private String buyerName;
	private int amountPurchesed;
	private OffsetDateTime datePurchased;
	private double totalValueOfPurchase;
	private Currency currency;
}

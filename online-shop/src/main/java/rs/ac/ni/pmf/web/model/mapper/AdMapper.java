package rs.ac.ni.pmf.web.model.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.model.api.AdDTO;
import rs.ac.ni.pmf.web.model.entity.AdEntity;

@Component
@RequiredArgsConstructor
public class AdMapper {

	public AdDTO toDto(final AdEntity adEntity) {
		return AdDTO.builder()
				.adID(adEntity.getAdID())
				.title(adEntity.getTitle())
				.description(adEntity.getDescription())
				.price(adEntity.getPrice())
				.currency(adEntity.getCurrency())
				.adPlacementDate(adEntity.getAdPlacementDate())
				//.purchaseID(adEntity.getPurchase().getId())
				.category(adEntity.getCategory())
				.status(adEntity.getStatus())
				.discountType(adEntity.getDiscountType())
				.discountValue(adEntity.getDiscountValue())
				.discountPercentage(adEntity.getDiscountPercentage())
				.discountValidity(adEntity.getDiscountValidity())
				.quantityAvailable(adEntity.getQuantityAvailable())
				//.userName(adEntity.getUser().getUserName())
				//.amountPurchased(adEntity.getAmountPurchased())
				.build();
	}
	
	public AdEntity toEntity(final AdDTO adDto) {
		return AdEntity.builder()
				.adID(adDto.getAdID())
				.title(adDto.getTitle())
				.description(adDto.getDescription())
				.price(adDto.getPrice())
				.currency(adDto.getCurrency())
				.adPlacementDate(adDto.getAdPlacementDate())
//				.purchase(Purchases.findPurchaseByUserID(adDto.getUserID()))
				.category(adDto.getCategory())
				//avarage rating mogu da ga izracunam posebnom metodom
				// za dobavljanje svih rejtinga pa podelim i to ubacim u entity
				// ako treba da sacuvam
				//.avgRating(adDto.getAvgRating())
				.status(adDto.getStatus())
				.quantityAvailable(adDto.getQuantityAvailable())
				.discountType(adDto.getDiscountType())
				.discountValue(adDto.getDiscountValue())
				.discountPercentage(adDto.getDiscountPercentage())
				.discountValidity(adDto.getDiscountValidity())
				//.userName(adDto.getUserName())
				//.amountPurchased(adDto.getAmountPurchased())
				.build();
	}
}

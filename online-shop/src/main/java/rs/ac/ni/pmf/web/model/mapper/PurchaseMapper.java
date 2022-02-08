package rs.ac.ni.pmf.web.model.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.model.api.PurchaseDTO;
import rs.ac.ni.pmf.web.model.entity.AdEntity;
import rs.ac.ni.pmf.web.model.entity.PurchaseEntity;
import rs.ac.ni.pmf.web.model.entity.UserEntity;

@Component
@RequiredArgsConstructor
public class PurchaseMapper {

	public PurchaseDTO toDto(final PurchaseEntity purchaseEntity) {
		return PurchaseDTO.builder()
				.purchaseID(purchaseEntity.getPurchaseID())
				.adID(purchaseEntity.getAd().getAdID())
				.buyerName(purchaseEntity.getBuyer().getUserName())
				.amountPurchesed(purchaseEntity.getAmountPurchesed())
				.datePurchased(purchaseEntity.getDatePurchased())
				.totalValueOfPurchase(purchaseEntity.getTotalValueOfPurchase())
				.currency(purchaseEntity.getCurrency())
				.build();
	}
	
	public PurchaseEntity toEntity(final PurchaseDTO purchaseDto) {
		return PurchaseEntity.builder()
				.purchaseID(purchaseDto.getPurchaseID())
				.ad(AdEntity.builder().adID(purchaseDto.getAdID()).build())
				.buyer(UserEntity.builder().userName(purchaseDto.getBuyerName()).build())
				.datePurchased(purchaseDto.getDatePurchased())
				.amountPurchesed(purchaseDto.getAmountPurchesed())
				.totalValueOfPurchase(purchaseDto.getTotalValueOfPurchase())
				.currency(purchaseDto.getCurrency())
				.build();
	}
}

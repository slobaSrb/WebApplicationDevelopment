package rs.ac.ni.pmf.web.service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.exception.BadRequestException;
import rs.ac.ni.pmf.web.exception.DuplicateResourceException;
import rs.ac.ni.pmf.web.exception.ResourceException;
import rs.ac.ni.pmf.web.exception.ResourceNotFoundException;
import rs.ac.ni.pmf.web.exception.ErrorInfo.ResourceType;
import rs.ac.ni.pmf.web.model.AdStatus;
import rs.ac.ni.pmf.web.model.Currency;
import rs.ac.ni.pmf.web.model.DiscountType;
import rs.ac.ni.pmf.web.model.api.AdDTO;
import rs.ac.ni.pmf.web.model.entity.AdEntity;
import rs.ac.ni.pmf.web.model.entity.UserEntity;
import rs.ac.ni.pmf.web.model.mapper.AdMapper;
import rs.ac.ni.pmf.web.repository.AdRepository;

@Service
@RequiredArgsConstructor
public class AdService {

	private final AdMapper adMapper;

	private final AdRepository adRepository;

	public List<AdDTO> getAllAds() {
		// TODO Auto-generated method stub
		return adRepository.findAll().stream().map(adMapper::toDto).collect(Collectors.toList());
	}

	public AdDTO getAd(final int adID) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		final AdEntity adEntity = adRepository.findById(adID).orElseThrow(
				() -> new ResourceNotFoundException(ResourceType.AD, "Ad that you are trying to get doesn't exist"));

		return adMapper.toDto(adEntity);
	}

	public AdDTO createAd(final AdDTO adDto) throws ResourceException, BadRequestException {
		if (adDto.getTitle() == null || adDto.getTitle().isEmpty() || adDto.getTitle().length() < 4) {
			throw new BadRequestException("Ad Title not valid!");
		}

		if (adDto.getPrice() == 0) {
			throw new BadRequestException("Ad price not valid!");
		}

		if (!Currency.exists(adDto.getCurrency())) {
			throw new BadRequestException("Ad currency not valid!");
		}
		if(!AdStatus.exists(adDto.getStatus())) {
			throw new BadRequestException("Ad status not valid!");
		}
		
		if (adDto.getDiscountType()!=null && adDto.getDiscountType() == DiscountType.Percentage) {
			if (adDto.getDiscountPercentage() == null || adDto.getDiscountPercentage() <= 0 || adDto.getDiscountPercentage() >= 100) {
				throw new BadRequestException("Ad discount percentage not valid!");
			}
		} else if (adDto.getDiscountType()!=null && adDto.getDiscountType() == DiscountType.Price) {
			if (adDto.getDiscountValue() == null || adDto.getDiscountValue() > adDto.getPrice()) {
				throw new BadRequestException("Ad price discount value not valid!");
			}
		} else if (adDto.getDiscountType()!=null && adDto.getDiscountType() == DiscountType.Quantity) {
			if (adDto.getDiscountValue() == null || adDto.getDiscountValue() > adDto.getQuantityAvailable()) {
				throw new BadRequestException("Ad quantity discount value not valid!");
			}
		}
		if (adDto.getDiscountValidity() != null && adDto.getDiscountValidity().toEpochSecond() <= OffsetDateTime.now().toEpochSecond()) {
			throw new BadRequestException("Ad discount validity not valid!");
		}
		
		// find ads with same title and check if they have same description and price
		// za duplicate resource mozda i ovo
		
		final int adID = adDto.getAdID();

		if (adRepository.existsById(adID)) {
			throw new DuplicateResourceException(ResourceType.AD, "Ad that you are trying to create already exists!");
		}

		final AdEntity adEntity = adMapper.toEntity(adDto);
		final AdEntity savedEntity = adRepository.save(adEntity);
		return adMapper.toDto(savedEntity);
	}

	public AdDTO updateAd(final int adID, final AdDTO adDto) throws ResourceException, BadRequestException {
		// TODO Auto-generated method stub
		if (adDto.getTitle() == null || adDto.getTitle().isEmpty() || adDto.getTitle().length() < 4) {
			throw new BadRequestException("Ad Title not valid!");
		}

		if (adDto.getPrice() == 0) {
			throw new BadRequestException("Ad price not valid!");
		}

		if (!Currency.exists(adDto.getCurrency())) {
			throw new BadRequestException("Ad currency not valid!");
		}
		if(!AdStatus.exists(adDto.getStatus())) {
			throw new BadRequestException("Ad status not valid!");
		}
		if (adDto.getDiscountType()!=null && adDto.getDiscountType() == DiscountType.Percentage) {
			if (adDto.getDiscountPercentage() == null || adDto.getDiscountPercentage() <= 0 || adDto.getDiscountPercentage() >= 100) {
				throw new BadRequestException("Ad discount percentage not valid!");
			}
		} else if (adDto.getDiscountType()!=null && adDto.getDiscountType() == DiscountType.Price) {
			if (adDto.getDiscountValue() == null || adDto.getDiscountValue() > adDto.getPrice()) {
				throw new BadRequestException("Ad price discount value not valid!");
			}
		} else if (adDto.getDiscountType()!=null && adDto.getDiscountType() == DiscountType.Quantity) {
			if (adDto.getDiscountValue() == null || adDto.getDiscountValue() > adDto.getQuantityAvailable()) {
				throw new BadRequestException("Ad quantity discount value not valid!");
			}
		}
		if (adDto.getDiscountValidity() != null && adDto.getDiscountValidity().toEpochSecond() <= OffsetDateTime.now().toEpochSecond()) {
			throw new BadRequestException("Ad discount validity not valid!");
		}
		
		// find ads with same title and check if they have same description and price
		// za duplicate resource mozda i ovo
		
		final int adDtoID = adDto.getAdID();

		if(adDtoID == 0 || adDtoID != adID) {
			throw new BadRequestException("Ad ids do not match!");
		}
		
//		boolean title_Val = true, ad_Placement_Date_Val = true;
	final AdEntity adEntity = adRepository.findById(adID).orElseThrow(
				() -> new ResourceNotFoundException(ResourceType.AD, "Ad that you are trying to update doesn't exist"));
//
//		if (adDto.getTitle() == null || adDto.getTitle().equals("") || adDto.getTitle().length() < 4) {
//			title_Val = false;
//		}


		// if (adEntity.getAdPlacementDate() != adDto.getAdPlacementDate()/* ||
		// adDto.getAdPlacementDate().toInstant() > LocalDate.now().toEpochDay() */) {
//		if (adDto.getAdPlacementDate() != null) {
//			ad_Placement_Date_Val = false;
//		}
		// }
		// sve treba obraditi logicki provera tj. osnovna validacija
	
	// mozda treba izracunati prosecan rejting ili mozda to u rating servisu ipak
		adEntity.setTitle(adDto.getTitle());
		adEntity.setDescription(adDto.getDescription());
		adEntity.setPrice(adDto.getPrice());
		adEntity.setCurrency(adDto.getCurrency());
		adEntity.setAdPlacementDate(adDto.getAdPlacementDate());
		adEntity.setCategory(adDto.getCategory());
		// avarage rating
		adEntity.setStatus(adDto.getStatus());
		adEntity.setQuantityAvailable(adDto.getQuantityAvailable());
		adEntity.setDiscountType(adDto.getDiscountType());
		adEntity.setDiscountValue(adDto.getDiscountValue());
		adEntity.setDiscountPercentage(adDto.getDiscountPercentage());
		adEntity.setDiscountValidity(adDto.getDiscountValidity());
		adEntity.setUser(UserEntity.builder().userName(adDto.getUserName()).build());
		// na kraju bi trebalo else throw new bad request exception ako nije promenjeno
		// nista
		// mada, trebalo bi da budu podaci u Dto-u isti svi, ako se desi da nisu dobri
		// onda treba bad request
//		if (!title_Val || !ad_Placement_Date_Val) {
//			throw new BadRequestException("Your request is bad, data is incoplete!");
//		}

		final AdEntity saveAd = adRepository.save(adEntity);

		return adMapper.toDto(saveAd);
	}

	public void deleteAd(final int adID) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (!adRepository.existsById(adID)) {
			throw new ResourceNotFoundException(ResourceType.AD, "Ad that you are trying to delete doesn't exist");
		}

		adRepository.deleteById(adID);
	}
}

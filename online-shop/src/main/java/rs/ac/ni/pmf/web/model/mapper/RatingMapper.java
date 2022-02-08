package rs.ac.ni.pmf.web.model.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.model.api.RatingDTO;
import rs.ac.ni.pmf.web.model.entity.AdEntity;
import rs.ac.ni.pmf.web.model.entity.RatingEntity;
import rs.ac.ni.pmf.web.model.entity.UserEntity;

@Component
@RequiredArgsConstructor
public class RatingMapper {

	public RatingDTO toDto(final RatingEntity ratingEntity) {
		return RatingDTO.builder()
				.ratingID(ratingEntity.getRatingID())
				.rating(ratingEntity.getRating())
				.ratingComment(ratingEntity.getRatingComment())
				.adID(ratingEntity.getAd().getAdID())
				.userName(ratingEntity.getUser().getUserName())
				.dateOfRatingPlacement(ratingEntity.getDateOfRating())
				.build();
	}
	
	public RatingEntity toEntity(final RatingDTO ratingDto) {
		return RatingEntity.builder()
				.ratingID(ratingDto.getRatingID())
				.rating(ratingDto.getRating())
				.ratingComment(ratingDto.getRatingComment())
				.ad(AdEntity.builder().adID(ratingDto.getRatingID()).build())
				.user(UserEntity.builder().userName(ratingDto.getUserName()).build())
				.dateOfRating(ratingDto.getDateOfRatingPlacement())
				.build();
	}
}

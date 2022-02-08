package rs.ac.ni.pmf.web.model.api;

import java.time.OffsetDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import rs.ac.ni.pmf.web.model.api.UserDTO.UserDTOBuilder;

@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class RatingDTO {
	private int ratingID;
	private int rating;
	private String ratingComment;
	private int adID;
	private String userName;
	private OffsetDateTime dateOfRatingPlacement;
}

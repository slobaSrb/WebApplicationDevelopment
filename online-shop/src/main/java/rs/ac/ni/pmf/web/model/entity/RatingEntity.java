package rs.ac.ni.pmf.web.model.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "ratings")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class RatingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ratingID;
	
	@Column(name = "rating", nullable = false)
	private int rating;
	
	@Column(name = "rating_comment", nullable = true)
	private String ratingComment;
	
	@ManyToOne
	@JoinColumn(name = "userName")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "adID")
	private AdEntity ad;

	@Column(name = "date_of_rating", nullable = false)
	private OffsetDateTime dateOfRating;
}

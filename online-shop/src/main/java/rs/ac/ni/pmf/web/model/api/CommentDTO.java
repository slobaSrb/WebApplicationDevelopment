package rs.ac.ni.pmf.web.model.api;

import java.time.OffsetDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class CommentDTO {
	private int commentID;
	private String comment;
	private OffsetDateTime commentDate;
	private String userName;
	private Integer mainCommentID;
	private int adID;
}

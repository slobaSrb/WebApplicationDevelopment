package rs.ac.ni.pmf.web.model.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import rs.ac.ni.pmf.web.model.Roles;


@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserDTO {
	//private int userID;
	private String userName;
	private String fullName;
	private String email;
	private String password;
	private Integer avgRating;
	//private String salt;
	private Roles role;
}

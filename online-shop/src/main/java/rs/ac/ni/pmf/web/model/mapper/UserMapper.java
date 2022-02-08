package rs.ac.ni.pmf.web.model.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.model.api.UserDTO;
import rs.ac.ni.pmf.web.model.entity.UserEntity;

@Builder
@Component
@RequiredArgsConstructor
public class UserMapper {

	// private final PasswordEncoder passwordEncoder;
	
	private final PasswordEncoder passwordEncoder;

	
	
	public UserDTO toDto(final UserEntity userEntity) {
		
		return UserDTO.builder()
				//.userID(userEntity.getUserID())
				.userName(userEntity.getUserName())
				.fullName(userEntity.getFullName())
				.email(userEntity.getEmail())
				.role(userEntity.getRole())
				.password(userEntity.getPassword())
				
				//vrv se ovako ne radi nego mora da se uzmu svi ratinzi za odredjenog usera
				//.avgRating(userEntity.getAvgRating())
				//ne bi smelo rolu da mu otkrije po nekom mom ubedjenju
				.build();
	}

	public UserEntity toEntity(final UserDTO userDto /*, RolesOfUser userRole*/) {
		return UserEntity.builder()
				//.userID(userDto.getUserID())
				.userName(userDto.getUserName())
				.fullName(userDto.getFullName())
				.email(userDto.getEmail())
				.role(userDto.getRole())
				//.password(passwordEncoder.encode(userDto.getPassword()))
				.password(passwordEncoder.encode(userDto.getPassword()))
				//isti komentar odozgo
				//.avgRating(userDto.getAvgRating())
				
				// kako promeniti password useru
				
				// rola se ne menja 
				// ostali atributi se isto ne menjaju
				// pitanje je da l se to dobavi iz baze, videcemo u servisima
				.build();
	}
}

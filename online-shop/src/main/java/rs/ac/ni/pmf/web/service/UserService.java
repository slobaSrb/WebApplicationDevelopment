package rs.ac.ni.pmf.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.exception.BadRequestException;
import rs.ac.ni.pmf.web.exception.DuplicateResourceException;
import rs.ac.ni.pmf.web.exception.ErrorInfo.ResourceType;
import rs.ac.ni.pmf.web.exception.ResourceNotFoundException;
import rs.ac.ni.pmf.web.model.Roles;
import rs.ac.ni.pmf.web.model.api.UserDTO;
import rs.ac.ni.pmf.web.model.entity.UserEntity;
import rs.ac.ni.pmf.web.model.mapper.UserMapper;
import rs.ac.ni.pmf.web.repository.UserRepository;

//@Data
@Service
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

	private final UserMapper userMapper;

	private final UserRepository userRepository;
	// private final RolesOfUserRepository typeRepository;

	private final PasswordEncoder passwordEncoder;

//	@PostConstruct
//	public void constructUser() {
//		
//	}
	
	public List<UserDTO> getAllTUsers() {
		return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
	}

	public UserDTO getUser(final String user_name) throws ResourceNotFoundException {
		final UserEntity userEntity = userRepository.findById(user_name)
				.orElseThrow(() -> new ResourceNotFoundException(ResourceType.USER,
						"User that you are trying to get doesn't exist"));
		return userMapper.toDto(userEntity);
	}

	public UserDTO createUser(final UserDTO userDto)
			throws DuplicateResourceException, ResourceNotFoundException, BadRequestException {
		final String user_name = userDto.getUserName();
		final Roles role = userDto.getRole();
		if (user_name == null || user_name.equals("") || user_name.length() < 4) {
			throw new BadRequestException("User name of user that you are trying to create is not valid");
		}
		if (userRepository.existsById(user_name)) {
			throw new DuplicateResourceException(ResourceType.USER,
					"User that you are trying to create already exists");
		}

		// final RolesOfUser typeEntity= typeRepository.findById(role_id).orElseThrow(
		// ()-> new ResourceNotFoundException(ResourceType.ROLE, "User role doesn't
		// exist"));

		if (Roles.Admin != role || Roles.User != role) {
			throw new ResourceNotFoundException(ResourceType.ROLE,
					"Role that you are trying to assign to User doesn't exist");
		}

		final UserEntity userEntity = userMapper.toEntity(userDto/* , typeEntity */);
		final UserEntity savedEntity = userRepository.save(userEntity);
		return userMapper.toDto(savedEntity);
	}

	public UserDTO updateUser(final String user_name, final UserDTO userDTO)
			throws ResourceNotFoundException, BadRequestException {

		/*
		 * if(userDTO.getIndex().equals(null) || !index.equals(userDTO.getIndex())) {
		 * 
		 * }
		 */

		if (user_name == null || user_name.equals("") || user_name.length() < 4) {
			throw new BadRequestException("User name of user that you are trying to update is not valid");
		}
		final UserEntity userEntity = userRepository.findById(user_name)
				.orElseThrow(() -> new ResourceNotFoundException(ResourceType.USER,
						"User that you are trying to update doesn't exist"));

		// userEntity.setUserID(userDTO.getUserID());
		// liste verovatno ne treba dirati jer se one brisu preko njihovih kontrolera
//		userEntity.setAds(ads);
		if (userDTO.getUserName().length() >= 4)
			if (!userEntity.getUserName().equals(userDTO.getUserName()))
				userEntity.setUserName(userDTO.getUserName());
		if (userDTO.getFullName().length() >= 4)
			if (!userEntity.getFullName().equals(userDTO.getFullName()))
				userEntity.setFullName(userDTO.getFullName());
		if (userDTO.getEmail().length() >= 4)
			if (!userEntity.getEmail().equals(userDTO.getEmail()))
				userEntity.setEmail(userDTO.getEmail());
		if (userDTO.getPassword().length() >= 4)
			if (!userEntity.getPassword().equals(passwordEncoder.encode(userDTO.getPassword())))
				userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		// if(!userEntity.)
		// userEntity.setAvgRating(userDTO.getAvgRating());
		// password dto ne bi trebalo da prikazuje kao i salt
		// userEntity.setPassword(userDTO.getPassword());
		// userEntity.setPurchases(purchases);
		// userEntity.setRatings(ratings);
		// ovo verovatno i ne treba da se expose-uje u dto
		// userEntity.setSalt(userDTO.getSalt());

		final UserEntity saveUser = userRepository.save(userEntity);

		return userMapper.toDto(saveUser);
	}

	public UserDTO changeUserRole(String user_name, int roleID, UserDTO userDto)
			throws ResourceNotFoundException, BadRequestException {

		final Roles role = Roles.values()[roleID];
		final UserEntity userEntity = userRepository.findById(user_name)
				.orElseThrow(() -> new ResourceNotFoundException(ResourceType.USER,
						"User that you are trying to update doesn't exist"));
		if (Roles.Admin != role || Roles.User != role) {
			throw new ResourceNotFoundException(ResourceType.ROLE,
					"Role that you are trying to assign to User doesn't exist");
		}
		if (userDto.getRole() != role) {
			throw new BadRequestException("Roles that you are trying to assing doesn't match");
		}

		userEntity.setRole(userDto.getRole());

		final UserEntity saveUser = userRepository.save(userEntity);

		return userMapper.toDto(saveUser);

	}

	public void deleteUser(final String user_name) throws ResourceNotFoundException {
		if (!userRepository.existsById(user_name)) {
			throw new ResourceNotFoundException(ResourceType.USER, "User that you are trying to delete doesn't exist");
		}

		userRepository.deleteById(user_name);
	}
}

package rs.ac.ni.pmf.web.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.controller.IUserController;
import rs.ac.ni.pmf.web.exception.BadRequestException;
import rs.ac.ni.pmf.web.exception.DuplicateResourceException;
import rs.ac.ni.pmf.web.exception.ResourceException;
import rs.ac.ni.pmf.web.exception.ResourceNotFoundException;
import rs.ac.ni.pmf.web.model.api.UserDTO;
import rs.ac.ni.pmf.web.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController implements IUserController {
	
	private final UserService userService;

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return userService.getAllTUsers();
	}
	
	@Override
	public UserDTO getUser(String userName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return userService.getUser(userName);
	}

	@Override
	public UserDTO createUser(UserDTO user)throws DuplicateResourceException, ResourceNotFoundException, BadRequestException {
		// TODO Auto-generated method stub
		return userService.createUser(user);
	}
	
	@Override
	public UserDTO updateUser(String userName, UserDTO user) throws ResourceNotFoundException, BadRequestException {
		// TODO Auto-generated method stub
		return userService.updateUser(userName, user);
	}

	@Override
	public UserDTO changeUserRole(String userName, int roleID, UserDTO userDto) throws ResourceException, BadRequestException {
		// TODO Auto-generated method stub
		return userService.changeUserRole(userName,roleID,userDto);
	}
	@Override
	public void deleteUser(String userName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		userService.deleteUser(userName);
	}
}

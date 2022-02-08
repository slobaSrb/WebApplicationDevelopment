package rs.ac.ni.pmf.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import rs.ac.ni.pmf.web.exception.BadRequestException;
import rs.ac.ni.pmf.web.exception.ResourceException;
import rs.ac.ni.pmf.web.exception.ResourceNotFoundException;
import rs.ac.ni.pmf.web.model.api.UserDTO;

@RequestMapping(path="/users")
public interface IUserController {
	
	/*
	 *	GET getAllUsers();  
	 *  services/rest/users
	*/
	@RequestMapping(method = RequestMethod.GET, path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	List<UserDTO> getAllUsers();

	/*
	 *	GET getUser();  
	 *  services/rest/users/{userName}
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	UserDTO getUser(@PathVariable(name = "userName") String userName) throws ResourceNotFoundException;

	/*
	 *	POST createUser();  
	 *  services/rest/users
	*/
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	UserDTO createUser(@RequestBody UserDTO user) throws ResourceException, BadRequestException;

	/*
	 *	PUT PATCH updateUser();  
	 *  services/rest/users/{userName}
	*/
	@ResponseStatus(code = HttpStatus.RESET_CONTENT)
	@RequestMapping(method = RequestMethod.PUT, path = "/{userName}", consumes = MediaType.APPLICATION_JSON_VALUE)
	UserDTO updateUser(@PathVariable(name = "userName") String userName, @RequestBody UserDTO user) throws ResourceException, BadRequestException;

	// trebalo bi da postoji poziv koji bi promenio samo rolu useru
	/*
	 *	PUT PATCH changeUserRole();  
	 *  services/rest/users/{userName}/changeRole/{roleID}
	*/
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.PATCH, path = "/{userName}/changeRole/{roleID}", consumes = MediaType.APPLICATION_JSON_VALUE)
	UserDTO changeUserRole(@PathVariable(name = "userName") String userName,@PathVariable(name = "roleID") int roleID, @RequestBody UserDTO userDto) throws ResourceException, BadRequestException;
	
	
	// change password of the user
	// choose whether admin can change it or user itself
	//throught authentification, repeating it's password
	
	
	/*
	 *	DELETE deleteUser();  
	 *  services/rest/users/{userName}
	*/
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.DELETE, path = "/{userName}")
	void deleteUser(@PathVariable(name = "userName") String userName) throws ResourceNotFoundException;
	
}

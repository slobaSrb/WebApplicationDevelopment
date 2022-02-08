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
import rs.ac.ni.pmf.web.model.api.AdDTO;
import rs.ac.ni.pmf.web.model.api.RatingDTO;
import rs.ac.ni.pmf.web.model.api.UserDTO;

@RequestMapping(path="")
public interface IRatingController {
	
	
	/*
	 *	GET getAllUserRatings();  
	 *  services/rest/users/{userID}/ratings
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/users/{userID}/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
	List<RatingDTO> getAllUserRatings(@PathVariable(name = "userID") int userID) throws ResourceNotFoundException;

	/*
	 *	GET getUserRating();  
	 *  services/rest/users/{userID}/ratings/{ratingID}
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/users/{userID}/ratings/{ratingID}", produces = MediaType.APPLICATION_JSON_VALUE)
	RatingDTO getUserRating(@PathVariable(name = "userID") int userID, @PathVariable(name = "ratingID") int ratingID) throws ResourceNotFoundException;

	/*
	 *	GET getAllUserAdRatings();  
	 *  services/rest/users/{userID}/ads/{adID}/ratings
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/users/{userID}/ads/{adID}/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
	List<RatingDTO> getAllUserAdRatings(@PathVariable(name = "userID") int userID, @PathVariable(name = "adID") int adID) throws ResourceNotFoundException;
	
	/*
	 *	GET saveUserAdRating();  
	 *  services/rest/users/{userID}/ads
	*/
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, path = "/users/{userID}/ads/{adID}/ratings", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	RatingDTO saveUserAdRating(@PathVariable(name = "userID") int userID,@PathVariable(name = "adID") int adID, @RequestBody RatingDTO rating) throws ResourceException, BadRequestException;

	/*
	 *	GET updateUserRating();  
	 *  services/rest/users/{userID}/ratings/{ratingID}
	*/
	@ResponseStatus(code = HttpStatus.RESET_CONTENT)
	@RequestMapping(method = RequestMethod.PUT, path = "/users/{userID}/ratings/{ratingID}", consumes = MediaType.APPLICATION_JSON_VALUE)
	RatingDTO updateUserRating(@PathVariable(name = "userID") int userID, @PathVariable(name = "ratingID") int ratingID, @RequestBody RatingDTO rating) throws ResourceException, BadRequestException;

	/*
	 *	GET deleteUserRating();  
	 *  services/rest/users/{userID}/ratings/{ratingID}
	*/
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.DELETE, path = "/users/{userID}/ratings/{ratingID}")
	void deleteUserRating(@PathVariable(name = "userID") int userID, @PathVariable(name = "ratingID") int ratingID) throws ResourceNotFoundException;

}

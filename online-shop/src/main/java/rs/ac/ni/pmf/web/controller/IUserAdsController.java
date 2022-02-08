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

@RequestMapping(path = "/users")
public interface IUserAdsController {
	
	/*
	 *	GET getAllUserAds();  
	 *  services/rest/users
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/{userID}/ads", produces = MediaType.APPLICATION_JSON_VALUE)
	List<AdDTO> getAllUserAds(@PathVariable(name = "userID") int userID) throws ResourceNotFoundException;

	/*
	 *	GET getUserAd();  
	 *  services/rest/users/{userID}/ads/{adID}
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/{userID}/ads/{adID}", produces = MediaType.APPLICATION_JSON_VALUE)
	AdDTO getUserAd(@PathVariable(name = "userID") int userID, @PathVariable(name = "adID") int adID) throws ResourceNotFoundException;

	/*
	 *	GET saveUserAd();  
	 *  services/rest/users/{userID}/ads
	*/
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, path = "/{userID}/ads", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	AdDTO saveUserAd(@PathVariable(name = "userID") int userID, @RequestBody AdDTO ad) throws ResourceException, BadRequestException;

	/*
	 *	GET updateUserAd();  
	 *  services/rest/users/{userID}/ads/{adID}
	*/
	@ResponseStatus(code = HttpStatus.RESET_CONTENT)
	@RequestMapping(method = RequestMethod.PUT, path = "/{userID}/ads/{adID}", consumes = MediaType.APPLICATION_JSON_VALUE)
	AdDTO updateUserAd(@PathVariable(name = "userID") int userID, @PathVariable(name = "adID") int adID, @RequestBody AdDTO ad) throws ResourceException, BadRequestException;
	
	/*
	 *	GET deleteUserAd();  
	 *  services/rest/users/{userID}/ads/{adID}
	*/
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.DELETE, path = "/{userID}/ads/{id}")
	void deleteAd(@PathVariable(name = "userID") int userID, @PathVariable(name = "adID") int adID) throws ResourceNotFoundException;

}

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

@RequestMapping(path = "/ads")
public interface IAdController {
	
	/*
	 *	GET getAllAds();  
	 *  services/rest/ads
	*/
	@RequestMapping(method = RequestMethod.GET, path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	List<AdDTO> getAllAds();

	/*
	 *	GET getAd();  
	 *  services/rest/ads/{id}
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/{adID}", produces = MediaType.APPLICATION_JSON_VALUE)
	AdDTO getAd(@PathVariable(name = "adID") int adID) throws ResourceNotFoundException;

	/*
	 *	POST createAd();  
	 *  services/rest/ads
	*/
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	AdDTO createAd(@RequestBody AdDTO adDto) throws ResourceException, BadRequestException;

	/*
	 *	PUT updateAd();  
	 *  services/rest/ads/{id}
	*/
	@ResponseStatus(code = HttpStatus.RESET_CONTENT)
	@RequestMapping(method = RequestMethod.PUT, path = "/{adID}", consumes = MediaType.APPLICATION_JSON_VALUE)
	AdDTO updateAd(@PathVariable(name = "adID") int adID, @RequestBody AdDTO adDto) throws ResourceException, BadRequestException;

	/*
	 *	DELETE deleteAd();  
	 *  services/rest/ads/{adID}
	*/
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.DELETE, path = "/{adID}")
	void deleteAd(@PathVariable(name = "adID") int adID) throws ResourceNotFoundException;

	/*
	 *	GET enableAd();  
	 *  services/rest/ads/{adID}/available
	*/
	
	
	/*
	 *	GET outOfStockAd();  
	 *  services/rest/ads/{adID}/outofstock
	*/
	
	/*
	 *	GET removeAd();  
	 *  services/rest/ads/{adID}/removed
	*/
	
	
}

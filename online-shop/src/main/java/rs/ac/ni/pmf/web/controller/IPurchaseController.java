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
import rs.ac.ni.pmf.web.model.api.PurchaseDTO;

@RequestMapping(path = "")
public interface IPurchaseController {
	
	/*
	 *	GET getAllUserPurchases();  
	 *  services/rest/users/{userID}/purchases
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/users/{userID}/purchases", produces = MediaType.APPLICATION_JSON_VALUE)
	List<PurchaseDTO> getAllUserPurchase(@PathVariable(name = "userID") int userID) throws ResourceNotFoundException;

	/*
	 *	GET getUserPurchase();  
	 *  services/rest/users/{userID}/purchases/{purchaseID}
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/users/{userID}/purchases/{purchaseID}", produces = MediaType.APPLICATION_JSON_VALUE)
	PurchaseDTO getUserPurchase(@PathVariable(name = "userID") int userID, @PathVariable(name = "purchaseID") int purchaseID) throws ResourceNotFoundException;

	/*
	 *	GET saveUserPurchase();  
	 *  services/rest/users/{userID}/purchases
	*/
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, path = "/users/{userID}/purchases", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	PurchaseDTO saveUserPurchase(@PathVariable(name = "userID") int userID, @RequestBody PurchaseDTO purchase) throws ResourceException, BadRequestException;

	/*
	 *	GET patchUserPurchase();  
	 *  services/rest/users/{userID}/purchase/{purchaseID}
	*/
	@ResponseStatus(code = HttpStatus.RESET_CONTENT)
	@RequestMapping(method = RequestMethod.PATCH, path = "/{userID}/ads/{purchaseID}", consumes = MediaType.APPLICATION_JSON_VALUE)
	PurchaseDTO patchUserPurchase(@PathVariable(name = "userID") int userID, @PathVariable(name = "purchaseID") int purchaseID, @RequestBody PurchaseDTO purchase) throws ResourceException, BadRequestException;

	/*  All status changes of the purchase
	 * 
	 * 
	 *	GET enableAd();  
	 *  services/rest/users/{userID}/purchase/{purchaseID}/preparing
	*/
	
	
	/*
	 *	GET outOfStockAd();  
	 *  services/rest/users/{userID}/purchase/{purchaseID}/deniedowner
	*/
	
	/*
		
		DOPISATI OSTALE PROMENE STATUSA POSILJKE

	*/
	
	
	/*
	 *	GET deleteUserAd();  
	 *  services/rest/users/{userID}/ads/{adID}
	*/
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.DELETE, path = "/{userID}/ads/{id}")
	void deleteAd(@PathVariable(name = "userID") int userID, @PathVariable(name = "adID") int adID) throws ResourceNotFoundException;

}

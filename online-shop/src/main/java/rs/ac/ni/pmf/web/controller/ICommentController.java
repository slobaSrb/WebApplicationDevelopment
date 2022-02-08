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
import rs.ac.ni.pmf.web.model.api.CommentDTO;
import rs.ac.ni.pmf.web.model.api.UserDTO;

@RequestMapping(path = "/ads")
public interface ICommentController {
	
	/*
	 *	GET getAllAdComments();  
	 *  services/rest/ads/{adID}/comments
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/{adID}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
	List<CommentDTO> getAllAdComments(@PathVariable(name = "adID") int adID);

	/*
	 *	GET getAdComment();  
	 *  services/rest/ads/{adID}/comments/{commentID}
	*/
	@RequestMapping(method = RequestMethod.GET, path = "/{adID}/comments/{commentID}", produces = MediaType.APPLICATION_JSON_VALUE)
	CommentDTO getAdComment(@PathVariable(name = "adID") int adID, @PathVariable(name = "commentID") int commentID) throws ResourceNotFoundException;

	/*
	 *	POST saveAdCommeent();  
	 *  services/rest/ads/{adID}/comments
	*/
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, path = "/{adID}/comments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	CommentDTO saveAdComment(@PathVariable(name = "adID") int adID, @RequestBody CommentDTO comment) throws ResourceException, BadRequestException;

	/*
	 *	PUT updateAdComment();  
	 *  services/rest/ads/{adID}/comments/{commentID}
	*/
	@ResponseStatus(code = HttpStatus.RESET_CONTENT)
	@RequestMapping(method = RequestMethod.PUT, path = "/{adID}/comments/{commentID}", consumes = MediaType.APPLICATION_JSON_VALUE)
	CommentDTO updateAdComment(@PathVariable(name = "adID") int adID, @PathVariable(name = "commentID") int commentID, @RequestBody CommentDTO comment) throws ResourceException, BadRequestException;

	/*
	 *	DELETE deleteAdComment();  
	 *  services/rest/ads/{adID}/comments/{commentID}
	*/
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.DELETE, path = "/{adID}/comments/{commentID}")
	void deleteAdComment(@PathVariable(name = "adID") int adID, @PathVariable(name = "commentID") int commentID) throws ResourceNotFoundException;
	
}

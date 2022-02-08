package rs.ac.ni.pmf.web.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.controller.ICommentController;
import rs.ac.ni.pmf.web.exception.BadRequestException;
import rs.ac.ni.pmf.web.exception.ResourceException;
import rs.ac.ni.pmf.web.exception.ResourceNotFoundException;
import rs.ac.ni.pmf.web.model.api.CommentDTO;
import rs.ac.ni.pmf.web.service.AdService;
import rs.ac.ni.pmf.web.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController implements ICommentController {

	private final CommentService commentService;
	@Override
	public List<CommentDTO> getAllAdComments(int adID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDTO getAdComment(int adID, int commentID) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDTO saveAdComment(int adID, CommentDTO comment) throws ResourceException, BadRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDTO updateAdComment(int adID, int commentID, CommentDTO comment)
			throws ResourceException, BadRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAdComment(int adID, int commentID) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
	}

}

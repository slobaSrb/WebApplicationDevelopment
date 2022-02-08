package rs.ac.ni.pmf.web.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.exception.BadRequestException;
import rs.ac.ni.pmf.web.exception.DuplicateResourceException;
import rs.ac.ni.pmf.web.exception.ResourceException;
import rs.ac.ni.pmf.web.exception.ResourceNotFoundException;
import rs.ac.ni.pmf.web.exception.ErrorInfo.ResourceType;
import rs.ac.ni.pmf.web.model.api.CommentDTO;
import rs.ac.ni.pmf.web.model.entity.AdEntity;
import rs.ac.ni.pmf.web.model.entity.CommentEntity;
import rs.ac.ni.pmf.web.model.mapper.AdMapper;
import rs.ac.ni.pmf.web.model.mapper.CommentMapper;
import rs.ac.ni.pmf.web.repository.AdRepository;
import rs.ac.ni.pmf.web.repository.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final AdMapper adMapper;
	private final CommentMapper commentMapper;

	private final AdRepository adRepository;
	private final CommentRepository commentRepository;

	private final AdService adService;

	public List<CommentDTO> getAllAdComments(int adID) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		adRepository.findById(adID).orElseThrow(() -> new ResourceNotFoundException(ResourceType.AD,
				"Ad that you are trying to create comment for doesn't exist"));

		return commentRepository.findAll().stream().filter(c -> c.getAd().getAdID() == adID).map(commentMapper::toDto)
				.collect(Collectors.toList());
	}

	public CommentDTO getAdComment(int adID, int commentID) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		adRepository.findById(adID).orElseThrow(() -> new ResourceNotFoundException(ResourceType.AD,
				"Ad that you are trying to get comment from doesn't exist"));

		final CommentEntity commentEntity = commentRepository.findById(commentID)
				.orElseThrow(() -> new ResourceNotFoundException(ResourceType.COMMENT,
						"Comment that you are trying to get doesn't exist"));

		return commentMapper.toDto(commentEntity);// .findById(commentID) throws ResourceNotFoundException;
	}

	public CommentDTO createAdComment(int adID, CommentDTO comment)
			throws ResourceException, BadRequestException, DuplicateResourceException {
		// TODO Auto-generated method stub
		adRepository.findById(adID).orElseThrow(() -> new ResourceNotFoundException(ResourceType.AD,
				"Ad that you are trying to create comment for doesn't exist"));

		final int comment_id = comment.getCommentID();

		if (/* comment_id == 0 && */ commentRepository.existsById(comment_id)) {
			throw new DuplicateResourceException(ResourceType.COMMENT,
					"The comment that you are trying to create already exists");
		}

		final CommentEntity commentEntity = commentMapper.toEntity(comment);
		final CommentEntity savedEntity = commentRepository.save(commentEntity);

		return commentMapper.toDto(savedEntity);
	}

	public CommentDTO updateAdComment(int adID, int commentID, CommentDTO commentDto)
			throws ResourceException, BadRequestException {
		adRepository.findById(adID).orElseThrow(() -> new ResourceNotFoundException(ResourceType.AD,
				"Ad that you are trying to update comment for doesn't exist"));
		boolean title_Val = true, ad_Placement_Date_Val = true;
		final CommentEntity commentEntity = commentRepository.findById(commentID).orElseThrow(
				() -> new ResourceNotFoundException(ResourceType.COMMENT, "Comment that you are trying to update doesn't exist"));
		// TODO Auto-generated method stub
		if(commentDto.getComment().equals("") || commentDto.getComment() == null) {
			throw new BadRequestException("Comment that you are trying to update is not valid!");
		}
		commentEntity.setComment(commentDto.getComment());
		commentEntity.setCommentDate(OffsetDateTime.now());
		//commentEntity.setCommentID(commentDto.getCommentID());
		return commentMapper.toDto(commentEntity);
	}

	public void deleteAdComment(int adID, int commentID) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (!adRepository.existsById(adID)) {
			throw new ResourceNotFoundException(ResourceType.AD, "Ad that you are trying to delete comment from doesn't exist");
		}
		if (!commentRepository.existsById(commentID)) {
			throw new ResourceNotFoundException(ResourceType.COMMENT, "Ad that you are trying to delete doesn't exist");
		}
		
		commentRepository.deleteById(commentID);
	}
}

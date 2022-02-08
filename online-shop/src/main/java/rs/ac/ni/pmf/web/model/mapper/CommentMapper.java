package rs.ac.ni.pmf.web.model.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.web.model.api.CommentDTO;
import rs.ac.ni.pmf.web.model.entity.AdEntity;
import rs.ac.ni.pmf.web.model.entity.CommentEntity;
import rs.ac.ni.pmf.web.model.entity.UserEntity;

@Component
@RequiredArgsConstructor
public class CommentMapper {

	public CommentDTO toDto(final CommentEntity commentEntity) {
		return CommentDTO.builder()
				.commentID(commentEntity.getCommentID())
				.comment(commentEntity.getComment())
				.commentDate(commentEntity.getCommentDate())
				.userName(commentEntity.getUserCommenter().getUserName())
				.mainCommentID(commentEntity.getCommentID())
				.adID(commentEntity.getAd().getAdID())
				.build();
	}
	
	public CommentEntity toEntity(final CommentDTO commentDto) {
		return CommentEntity.builder()
				.commentID(commentDto.getCommentID())
				.comment(commentDto.getComment())
				.commentDate(commentDto.getCommentDate())
				.userCommenter(UserEntity.builder().userName(commentDto.getUserName()).build())
				.mainComment(CommentEntity.builder().commentID(commentDto.getCommentID()).build())
				.ad(AdEntity.builder().adID(commentDto.getAdID()).build())
				//.ad(commentDto.getAdID())
				.build();
	}
}

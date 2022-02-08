package rs.ac.ni.pmf.web.model.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentID;
	
	@Column(name = "comment", nullable = false)
	private String comment;
	
	@Column(name = "comment_date", nullable = false)
	private OffsetDateTime commentDate;
	
	@ManyToOne
	@JoinColumn(name = "userName")
	private UserEntity userCommenter;
	
	@ManyToOne
	@JoinColumn()
	private CommentEntity mainComment;
	
	@ManyToOne
	@JoinColumn(name = "adID")
	private AdEntity ad;
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mainComment")
	private List<CommentEntity> allSubComments = new ArrayList<>();
}

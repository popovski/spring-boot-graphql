package com.labs.iw.library.author.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.labs.iw.library.author.dto.AuthorResponseDTO;
import com.labs.iw.library.book.entity.Book;
import com.labs.iw.library.infrastructure.NativeQueries;
import com.labs.iw.library.infrastructure.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "author")
@SqlResultSetMapping(name = "AuthorResponseDTOConstructorMapping",
		classes = {
				@ConstructorResult(
						targetClass = AuthorResponseDTO.class,
						columns = {
								@ColumnResult(name = "AUTHORID", type = Long.class),
								@ColumnResult(name = "CREATEDON", type = Date.class),
								@ColumnResult(name = "UUID", type = String.class),
								@ColumnResult(name = "FIRSTNAME",type = String.class),
								@ColumnResult(name = "LASTNAME", type = String.class),
								@ColumnResult(name = "BOOKID", type = Long.class),
						}
				)
		})
@NamedNativeQueries(@NamedNativeQuery(name = "AuthorDTO.findAuthorsByBookIds",query = NativeQueries.findAuthorsByBookIds,
		resultSetMapping = "AuthorResponseDTOConstructorMapping"))
public class Author extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "firstName")
	private String firstName;
	
	@NotNull
	@Column(name = "lastName", length = 5000)
	private String lastName;
	
	@ManyToMany(mappedBy="authors", fetch=FetchType.LAZY)
	private List<Book> books;
}

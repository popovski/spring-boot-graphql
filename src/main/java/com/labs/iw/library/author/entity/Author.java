package com.labs.iw.library.author.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.labs.iw.library.book.entity.Book;
import com.labs.iw.library.infrastructure.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "author")
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

package com.labs.iw.library.book.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.labs.iw.library.author.entity.Author;
import com.labs.iw.library.infrastructure.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "title")
	private String title;
	
	@NotNull
	@Column(name = "description", length = 5000)
	private String description;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Author> authors;
}

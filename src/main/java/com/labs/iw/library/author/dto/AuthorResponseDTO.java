package com.labs.iw.library.author.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class AuthorResponseDTO {
	private long id;
	private Date createdOn;
	private String uuid;
	private String firstName;
	private String lastName;
	private long bookId;

	public AuthorResponseDTO(long id, Date createdOn, String uuid, String firstName, String lastName, long bookId) {
		this.id = id;
		this.createdOn = createdOn;
		this.uuid = uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bookId = bookId;
	}
}

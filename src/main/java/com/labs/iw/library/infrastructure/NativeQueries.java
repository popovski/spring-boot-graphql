package com.labs.iw.library.infrastructure;

public interface NativeQueries {

	String findAuthorsByBookIds = "SELECT a.id as AUTHORID, a.created_on as CREATEDON,"
			+ " a.uuid as UUID,a.first_name as FIRSTNAME, a.last_name as LASTNAME, book2_.id as bookId "
			+ " FROM author a left outer join book_authors books1_ on a.id=books1_.authors_id "
			+ " left outer join book book2_ on books1_.books_id=book2_.id "
			+ " where book2_.id in (?1)";

}

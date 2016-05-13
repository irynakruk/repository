package com.rest.web.server;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/books")
public class BookController {

	private BookService bookService = new BookService();

	@GET
	public Response getAllBooks() {
		return Response.status(200).entity(bookService.getAllBooks().toString()).build();
	}

	@GET
	@Path("{id}")
	public Response getBook(@PathParam("id") String paramId) {
		Long id = Long.valueOf(paramId);
		return Response.status(200).entity(bookService.getBook(id)).build();
	}

	@POST
	@Path("/add")
	public Response addBook(@FormParam("id") String paramId,
			@FormParam("name") String name, @FormParam("author") String author) {
		Long id = Long.valueOf(paramId);
		bookService.createBook(id, name, author);
		return Response.status(200).entity("Book with " + paramId + " ID added").build();
	}
}

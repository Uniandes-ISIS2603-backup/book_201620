/*
 * BookResource.java
 * Clase que representa el recurso "/books"
 * Implementa varios métodos para manipular las books
 */
package co.edu.uniandes.csw.bookstore.resources;

import co.edu.uniandes.csw.bookstore.ejb.BookLogic;
import co.edu.uniandes.csw.bookstore.dtos.BookDTO;
import co.edu.uniandes.csw.bookstore.dtos.BookDetailDTO;
import co.edu.uniandes.csw.bookstore.entities.BookEntity;
import co.edu.uniandes.csw.bookstore.exceptions.BookLogicException;
import java.util.ArrayList;

import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Clase que implementa el recurso REST correspondiente a "books".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "books". Al ejecutar la aplicación, el recurse
 * será accesibe a través de la ruta "/api/books"
 *
 * @citi Asistente
 */
@Path("books")
@Produces("application/json")
public class BookResource {

    @Inject
    BookLogic bookLogic;

    /**
     * Obtiene el listado de books.
     *
     * @return lista de books
     * @throws BookLogicException excepción retornada por la lógica
     */
    @GET
    public List<BookDetailDTO> getBooks() throws BookLogicException {
        return listEntity2DetailDTO(bookLogic.getBooks());
    }

    /**
     * Obtiene una book
     *
     * @param id identificador de la book
     * @return book encontrada
     * @throws BookLogicException cuando la book no existe
     */
    @GET
    @Path("{id: \\d+}")
    public BookDetailDTO getBook(@PathParam("id") Long id) throws BookLogicException {
        BookEntity bookE = bookLogic.getBook(id);
        return new BookDetailDTO(bookE);
    }

    /**
     * Agrega una book
     *
     * @param book book a agregar
     * @return datos de la book a agregar
     * @throws BookLogicException cuando ya existe una book con el id
     * suministrado
     */
    @POST
    public BookDTO createBook(BookDTO book) throws BookLogicException {
        return bookLogic.createBook(book);
    }

    /**
     * Actualiza los datos de una book
     *
     * @param id identificador de la book a modificar
     * @param book book a modificar
     * @return datos de la book modificada
     * @throws BookLogicException cuando no existe una book con el id
     * suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public BookDTO updateBook(@PathParam("id") Long id, BookDTO book) throws BookLogicException {
        return bookLogic.updateBook(id, book);
    }

    /**
     * Elimina los datos de una book
     *
     * @param id identificador de la book a eliminar
     * @throws BookLogicException cuando no existe una book con el id
     * suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBook(@PathParam("id") Long id) throws BookLogicException {
        bookLogic.deleteBook(id);
    }

    @Path("{booksId: \\d+}/authors")
    public Class<BookAuthorsResource> getBookAuthorsResource(@PathParam("booksId") Long booksId) throws BookLogicException {
        BookDTO book = getBook(booksId);
        if (book == null) {
            throw new BookLogicException("El libro no existe");
        }
        return BookAuthorsResource.class;
    }

    /**
     * Método encargado de realizar la transformación de una lista de Entity a
     * DetailDTO
     *
     * @param entityList Lista a ser transformada
     * @return Lista de elementos DTO
     */
    private List<BookDetailDTO> listEntity2DetailDTO(List<BookEntity> entityList) {
        List<BookDetailDTO> list = new ArrayList<>();
        for (BookEntity entity : entityList) {
            list.add(new BookDetailDTO(entity));
        }
        return list;
    }
}

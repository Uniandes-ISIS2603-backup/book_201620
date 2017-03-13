/*
 * AuthorDTO
 * Objeto de transferencia de datos de Ciudades.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 */
package co.edu.uniandes.rest.books.dtos;

import co.edu.uniandes.csw.bookstore.entities.AuthorEntity;
import java.util.Date;

/**
 * Objeto de transferencia de datos de Ciudades.
 *
 * @citi Asistente
 */
public class AuthorDetailDTO {

    private Long id;
    private String name;
    private Date birthDate;

    private BookDTO books;
    
  
    /**
     * Constructor por defecto
     */
    public AuthorDetailDTO() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id identificador de la book
     * @param name nombre de la book
     */
    public AuthorDetailDTO(AuthorEntity authorE) {
       super();
       
    }

    public AuthorEntity toEntity() {
        AuthorEntity authorE = new AuthorEntity();
        authorE.setId(this.id);
        authorE.setName(this.name);
         authorE.setBirthDate(this.birthDate);
        return authorE;
    }
    
    
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the books
     */
    public BookDTO getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(BookDTO books) {
        this.books = books;
    }

   
}

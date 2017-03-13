package co.edu.uniandes.csw.bookstore.entities;


import java.io.Serializable;
import javax.persistence.Entity;
import uk.co.jemos.podam.common.PodamExclude;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


/**
 * @generated
 */
@Entity
public class ReviewEntity extends BaseEntity implements Serializable {

    @PodamExclude
    @ManyToOne
    private BookEntity bookReviews;

    /**
     * Obtiene el atributo bookReviews.
     *
     * @return atributo bookReviews.
     * @generated
     */
    public BookEntity getBookReviews() {
        return bookReviews;
    }

    /**
     * Establece el valor del atributo bookReviews.
     *
     * @param bookReviews nuevo valor del atributo
     * @generated
     */
    public void setBookReviews(BookEntity bookreviews) {
        this.bookReviews = bookreviews;
    }
}

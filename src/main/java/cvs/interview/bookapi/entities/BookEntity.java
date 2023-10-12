package cvs.interview.bookapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "BOOKS")
public class BookEntity {
    @Id
    Long id;
    String title;
    String author;
    String publisher;
    Boolean stillHave;
    String location;
}

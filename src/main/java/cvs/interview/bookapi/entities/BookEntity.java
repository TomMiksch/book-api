package cvs.interview.bookapi.entities;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String title;
    String author;
    String publisher;
    Boolean stillHave;
    String location;
}

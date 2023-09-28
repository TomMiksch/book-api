package cvs.interview.bookapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

//@Entity
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
@Builder
@Table(name = "BOOKS")
public class BookEntity {
}

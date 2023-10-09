package cvs.interview.bookapi.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    Long id;
    String title;
    String author;
    String publisher;
}

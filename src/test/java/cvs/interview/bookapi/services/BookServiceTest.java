package cvs.interview.bookapi.services;

import cvs.interview.bookapi.dtos.BookDTO;
import cvs.interview.bookapi.entities.BookEntity;
import cvs.interview.bookapi.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Get All Books")
    public void getAllBooks() {
        List<BookDTO> expectedDTOs = asList(
            BookDTO.builder()
                .id(1L)
                .title("Book")
                .author("Author")
                .publisher("publisher")
                .build(),
            BookDTO.builder()
                .id(1L)
                .title("Diff")
                .author("Diff")
                .publisher("Diff")
                .build());

        List<BookEntity> expectedEntities = asList(
            BookEntity.builder()
                .id(1L)
                .title("Book")
                .author("Author")
                .publisher("publisher")
                .build(),
            BookEntity.builder()
                .id(1L)
                .title("Diff")
                .author("Diff")
                .publisher("Diff")
                .build());

        when(bookRepository.findAll()).thenReturn(expectedEntities);

        List<BookDTO> actual = bookService.getAllBooks();

        assertThat(actual).usingRecursiveComparison().isEqualTo(expectedDTOs);
    }
}

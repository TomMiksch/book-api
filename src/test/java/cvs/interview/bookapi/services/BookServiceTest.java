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
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
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

    @Test
    @DisplayName("Get Book By Id")
    public void getById() {
        Long id = 1L;

        BookEntity responseEntity = BookEntity.builder()
            .id(id)
            .title("Book")
            .author("Author")
            .publisher("publisher")
            .stillHave(true)
            .location("Home")
            .build();

        BookDTO expected = BookDTO.builder()
            .id(1L)
            .title("Book")
            .author("Author")
            .publisher("publisher")
            .stillHave(true)
            .location("Home")
            .build();

        when(bookRepository.findById(id)).thenReturn(of(responseEntity));

        BookDTO actual = bookService.getById(id);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    @DisplayName("Get Book By Id returns null")
    public void getByIdReturnsNull() {
        Long id = 1L;

        when(bookRepository.findById(id)).thenReturn(empty());

        BookDTO actual = bookService.getById(id);

        assertThat(actual).isEqualTo(null);
    }

    @Test
    @DisplayName("Save a book, no ID")
    public void saveBookNoId() {
        BookDTO input = BookDTO.builder()
            .id(null)
            .title("Book")
            .author("Author")
            .publisher("publisher")
            .stillHave(true)
            .location("Home")
            .build();

        BookDTO expected = BookDTO.builder()
            .id(1L)
            .title("Book")
            .author("Author")
            .publisher("publisher")
            .stillHave(true)
            .location("Home")
            .build();

        BookEntity saveEntity = BookEntity.builder()
            .id(null)
            .title("Book")
            .author("Author")
            .publisher("publisher")
            .stillHave(true)
            .location("Home")
            .build();

        BookEntity responseEntity = BookEntity.builder()
            .id(1L)
            .title("Book")
            .author("Author")
            .publisher("publisher")
            .stillHave(true)
            .location("Home")
            .build();

        when(bookRepository.save(eq(saveEntity))).thenReturn(responseEntity);

        BookDTO actual = bookService.saveBook(input);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}

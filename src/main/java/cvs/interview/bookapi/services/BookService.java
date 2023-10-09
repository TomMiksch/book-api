package cvs.interview.bookapi.services;

import cvs.interview.bookapi.dtos.BookDTO;
import cvs.interview.bookapi.entities.BookEntity;
import cvs.interview.bookapi.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        List<BookEntity> all = bookRepository.findAll();
        List<BookDTO> response = new ArrayList<>();
        all.forEach(entity -> response.add(entityToDTO(entity)));
        return response;
    }

    private static BookDTO entityToDTO(BookEntity entity) {
        return BookDTO.builder()
            .id(entity.getId())
            .author(entity.getAuthor())
            .title(entity.getTitle())
            .publisher(entity.getPublisher())
            .build();
    }
}

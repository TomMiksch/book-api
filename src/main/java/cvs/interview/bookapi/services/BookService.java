package cvs.interview.bookapi.services;

import cvs.interview.bookapi.dtos.BookDTO;
import cvs.interview.bookapi.entities.BookEntity;
import cvs.interview.bookapi.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public BookDTO getById(Long id) {
        Optional<BookEntity> optById = bookRepository.findById(id);
        return optById.map(BookService::entityToDTO).orElse(null);
    }

    public BookDTO saveBook(BookDTO bookDTO) {
//        TODO figure out what's wrong with this dumbass line of code
        return entityToDTO(bookRepository.save(dtoToEntity(bookDTO)));
    }

    private static BookDTO entityToDTO(BookEntity entity) {
        return BookDTO.builder()
            .id(entity.getId())
            .author(entity.getAuthor())
            .title(entity.getTitle())
            .publisher(entity.getPublisher())
            .stillHave(entity.getStillHave())
            .location(entity.getLocation())
            .build();
    }

    private static BookEntity dtoToEntity(BookDTO dto) {
        return BookEntity.builder()
            .id(dto.getId())
            .author(dto.getAuthor())
            .title(dto.getTitle())
            .publisher(dto.getPublisher())
            .stillHave(dto.getStillHave())
            .location(dto.getLocation())
            .build();
    }
}

package cvs.interview.bookapi.controllers;

import cvs.interview.bookapi.dtos.BookDTO;
import cvs.interview.bookapi.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        log.info("Hey!");
        return new ResponseEntity<>(bookService.getAllBooks(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getById(id), OK);
    }

    //    TODO save endpoint
    @PostMapping("/save")
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO bookDTO) {
        log.info("Wild");
        return new ResponseEntity<>(bookService.saveBook(bookDTO), OK);
    }
}

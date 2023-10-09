package cvs.interview.bookapi.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Get all books")
    public void setUp() throws Exception {
        mockMvc.perform(get("/book/getAll"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.[0].id").value(1))
            .andExpect(jsonPath("$.[0].title").value("The Godfather"))
            .andExpect(jsonPath("$.[0].author").value("Mario Puzo"))
            .andExpect(jsonPath("$.[0].publisher").value("Penguin"))
            .andExpect(jsonPath("$.[1].id").value(2))
            .andExpect(jsonPath("$.[1].title").value("Twelve Mighty Orphans"))
            .andExpect(jsonPath("$.[1].author").value("Jim Dent"))
            .andExpect(jsonPath("$.[1].publisher").value("Random House"))
            .andExpect(jsonPath("$.[2].id").value(3))
            .andExpect(jsonPath("$.[2].title").value("Daisy Jones and the Six"))
            .andExpect(jsonPath("$.[2].author").value("Taylor Jenkins Reid"))
            .andExpect(jsonPath("$.[2].publisher").value("Simon & Schuster"));
    }
}

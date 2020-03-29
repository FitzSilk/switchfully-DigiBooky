package com.switchfully.javadocjuveniles.domain.item.book;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void bookReturnsCorrectValues() {
        Author author = authorBuilder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .build();
        Book book = bookBuilder()
                .withISBN("1234")
                .withAuthor(author)
                .withDateAdded(LocalDate.of(2020, 3, 29))
                .withNumberOfCopies(2)
                .withSummary("summary")
                .withTitle("title")
                .build();
        assertEquals("1234", book.getISBN());
        assertEquals(author, book.getAuthor());
        assertEquals(LocalDate.of(2020, 3, 29), book.getDateAdded());
        assertEquals(2, book.getNumberOfCopies());
        assertEquals("summary", book.getSummary());
        assertEquals("title", book.getTitle());
        assertNotNull(book.getID());
        assertTrue(book.isAvailable());
    }
}
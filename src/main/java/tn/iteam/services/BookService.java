package tn.iteam.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tn.iteam.entites.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.iteam.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bRepo;

    public void save(Book b) {
        bRepo.save(b);
    }

    public List<Book> getAllBook() {
        return bRepo.findAll();
    }

    public Page<Book> getPaginatedBooks(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (search.isEmpty()) {
            return bRepo.findAll(pageable);
        } else {
            return bRepo.findByNameContainingIgnoreCase(search, pageable);
        }
    }

    public Book getBookById(int id) {
        return bRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void deleteById(int id) {
        bRepo.deleteById(id);
    }
}

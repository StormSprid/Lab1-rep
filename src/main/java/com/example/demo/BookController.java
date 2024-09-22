package com.example.demo;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")

public class BookController {
    @PostMapping("/add")
    public Book addBlock(@RequestBody Book book){
        book.setStatus("received");
        return book;
    }
}

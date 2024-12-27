package tn.iteam.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.iteam.entites.MyBookList;

@Service
public class MyBookListService {

    @Autowired
    private tn.iteam.repositories.MyBookRepository mybook;

    public void saveMyBooks(tn.iteam.entites.MyBookList book) {
        mybook.save(book);
    }

    public List<MyBookList> getAllMyBooks(){
        return mybook.findAll();
    }

    public void deleteById(int id) {
        mybook.deleteById(id);
    }
}
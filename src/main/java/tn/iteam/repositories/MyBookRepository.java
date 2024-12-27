package tn.iteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iteam.entites.MyBookList;


public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {
}

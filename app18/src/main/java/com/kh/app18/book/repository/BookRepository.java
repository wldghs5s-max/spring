package com.kh.app18.book.repository;

import com.kh.app18.book.entity.BookEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final EntityManager entityManager;


    public void save(BookEntity entity) {
        entityManager.persist(entity);
    }

    public List<BookEntity> findAll() {
        String jpql = """
            select b from BookEntity b where b.delYn = 'N' order by b.id desc
        """;
        return entityManager.createQuery(jpql,BookEntity.class).getResultList();
    }

    public BookEntity findById(Long id) {
        String jpql = """
            select b from BookEntity b where b.delYn = 'N' and b.id = :id
        """;
        return entityManager.createQuery(jpql, BookEntity.class)
                .setParameter("id",id)
                .getSingleResult();
    }
}

package com.kh.app17.book.repository;

import com.kh.app17.book.entity.BookEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final EntityManager em;

    public void save(BookEntity entity) {
        em.persist(entity);

    }


    public List<BookEntity> findAll() {
        String jpql = "select b from BookEntity b where b.delYn = 'N' order by id desc";

        return em.createQuery(jpql,BookEntity.class).getResultList();
    }

    public BookEntity findById(Long id) {
        String jpql = """
                select b from BookEntity b where b.delYn = 'N' and b.id = :id
        """;
        return em.createQuery(jpql,BookEntity.class)
                .setParameter("id",id)
                .getSingleResult();
    }
}

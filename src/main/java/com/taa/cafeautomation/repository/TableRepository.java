package com.taa.cafeautomation.repository;

import com.taa.cafeautomation.entitiy.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TableRepository extends JpaRepository<Tables, Integer> {
    Tables findById(int tableId);
    //Tables update(Tables table);

    @Query(value = """
    select t.* from tables t
    left join orders o on o.table_id=t.id and o.is_active=true
    where o.id is null
    """, nativeQuery = true)
    Optional<List<Tables>> findNonActiveTables();
}

package com.CockroachDbIntegration.repositories;


import com.CockroachDbIntegration.entities.ClientData;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<ClientData, Long> {
    @Modifying
    @Query("update ClientData c set c.username= :username , c.surname= :surname , c.firstname= :firstname where c.id= :id")
    void update(@Param("username") String username , @Param("surname") String surname , @Param("firstname") String firstname , @Param("id") long id);

}

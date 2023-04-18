package com.cursoSpringBoot.cursoSpringBoot.application.repository;

import com.cursoSpringBoot.cursoSpringBoot.application.entities.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReciboRepository extends JpaRepository<Recibo, Integer> {
    @Query("select r from Recibo r, Venta v where r.id= v.idRecibo and v.description = :descripcion")
    List<Recibo> findByDescription(@Param("descripcion")String descripcion);
}

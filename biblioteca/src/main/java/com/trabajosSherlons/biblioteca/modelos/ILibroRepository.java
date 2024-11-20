package com.trabajosSherlons.biblioteca.modelos;

import org.aspectj.apache.bcel.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibroRepository extends JpaRepository<Libro,Long> {

}

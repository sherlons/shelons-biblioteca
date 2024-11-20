package com.trabajosSherlons.biblioteca.service;

import com.trabajosSherlons.biblioteca.modelos.ILibroRepository;
import com.trabajosSherlons.biblioteca.modelos.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private ILibroRepository libroRepository;

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }
}
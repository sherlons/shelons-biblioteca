package com.trabajosSherlons.biblioteca.modelos;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLenguaje (
        @JsonAlias("languages") String idioma
){
}

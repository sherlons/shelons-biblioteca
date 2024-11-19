package com.trabajosSherlons.biblioteca.modelos;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalDeTemporadas,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Language") String idioma,
) {
}

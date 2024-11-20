package com.trabajosSherlons.biblioteca.principal;

import com.trabajosSherlons.biblioteca.modelos.Datos;
import com.trabajosSherlons.biblioteca.modelos.DatosLibro;
import com.trabajosSherlons.biblioteca.service.ConsumoAPI;
import com.trabajosSherlons.biblioteca.service.ConvertidorDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final  String URL_BACE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvertidorDatos convertidor= new ConvertidorDatos();
    Scanner usuario =  new Scanner (System.in);

    public void menuIncio(){

        var json = consumoAPI.otenerDatos(URL_BACE);

        var datos = convertidor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        // top 10 mas sestacados
        System.out.println("Top 10 lo mas Descargados");
        datos.libros().stream()
                .sorted(Comparator
                        .comparing(DatosLibro::numeroDescargas).reversed())
                .limit(10).map(l->l.titulo().toUpperCase())
                .forEach(System.out::println);

        // Buqueda por nombre

        System.out.println("Ingresa el nobre del libro que buscas");
        var tituloLibro = usuario.nextLine();
        json = consumoAPI.otenerDatos(URL_BACE + "?search="+tituloLibro.replace(" ", "+"));
        var datosBusqueda = convertidor.obtenerDatos(json, Datos.class );
        Optional<DatosLibro> librosBuscados = datosBusqueda.libros().stream()
                .filter(l->l.titulo().toUpperCase().
                        contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (librosBuscados.isPresent()){
            System.out.println("libro encontrado: \n" + librosBuscados.get());
        }else {
            System.out.println("No se encontro el libro");
        }
        System.out.println(datosBusqueda);

        // trabajando com estadisticas
        DoubleSummaryStatistics estadisticas= datos.libros().stream()
                .filter(d ->d.numeroDescargas()>0)
                .collect(Collectors.summarizingDouble(DatosLibro::numeroDescargas));
        System.out.println("Cantidad media de descargas: "+ estadisticas.getAverage()
                + "\n Cantidad maxima de descargas: " + estadisticas.getMax()
                + "\n Cantidida minima de descargas: )" + estadisticas.getMin()
                +"\n Cantidad de registros evaluados por la estadisticas: "+ estadisticas.getCount());
    }
}
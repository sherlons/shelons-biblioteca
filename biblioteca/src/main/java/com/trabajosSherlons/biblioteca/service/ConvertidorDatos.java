package com.trabajosSherlons.biblioteca.service;


public class ConvertidorDatos implements IconvertidorDatos{
    private ObjectMapper  objectMapper = new ObjectMapper();


    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {

        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException  e) {
            throw new RuntimeException(e);
        }
    }
}

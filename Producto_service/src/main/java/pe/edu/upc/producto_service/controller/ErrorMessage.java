package pe.edu.upc.producto_service.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

public class ErrorMessage {

    private String code ;
    private List<Map<String, String >> messages ;
}

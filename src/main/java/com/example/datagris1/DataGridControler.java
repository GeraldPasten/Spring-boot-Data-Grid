package com.example.datagris1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataGridControler {

     CallDataGrid call = new CallDataGrid();

    @GetMapping("/datagrid")
    public String CallApi (){
        return call.LlamarApi();
    }

    @GetMapping("/prueba")
    public String Probando (){
        return "Hola po";
    }
    
}

package com.example.datagris1;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataGridControler {

     CallDataGrid call = new CallDataGrid();

    @GetMapping("/datagrid")
    public String CallApi () throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException{
        return call.LlamarApi();
    }

    @GetMapping("/prueba")
    public String Probando (){
        return "Hola po";
    }
    
}

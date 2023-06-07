package com.example.datagris1;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CallDataGrid {

    String responsee;
    
    public String LlamarApi() {
        // Configurar credenciales de autenticación básica
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("admin", "password"));

        // Crear cliente HTTP con autenticación básica
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();

        try {
            // URL de la API 
            String apiUrl = "https://datagrid-lab-external-datagridcross.apps.cluster-n9q4j.n9q4j.sandbox2353.opentlc.com";

            // Crear solicitud GET con encabezados
            HttpGet httpGet = new HttpGet(apiUrl);
            httpGet.addHeader("accept", "application/json");

            // Ejecutar la solicitud
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            // Procesar la respuesta
            if (entity != null) {
                String responseBody = EntityUtils.toString(entity);
                System.out.println(responseBody);

                responsee = responseBody;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return responsee;
    }



}

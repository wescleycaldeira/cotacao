package br.com.dolar;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import br.com.dolar.v1.application.DolarApplication;
import br.com.dolar.v1.boundary.DolarRest;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@QuarkusTest
public class DolarRestTestIT {

    @Test
    public void testConsultaSucesso(){
        given()
          .when()
          .queryParam(DolarRest.QUERY_PARAM_DOLAR, "05-22-2020")
          .get(DolarRest.PATH_COTACAO_DOLAR)
          .then()
             .statusCode(200).assertThat()
             .body(CoreMatchers.containsString("valorVenda"))
             .body(CoreMatchers.containsString("valorCompra"));
    }

    @Test
    public void testDataIncorreta(){
        given()
          .when()
          .queryParam(DolarRest.QUERY_PARAM_DOLAR, "05-31-2020")
          .get(DolarRest.PATH_COTACAO_DOLAR)
          .then()
             .statusCode(400);
    }

    @Test
    public void testDataSuperirorAtual(){
        LocalDate dataIncorreta = LocalDate.now().plusDays(1);
        String dataIncorretaFormato = dataIncorreta.format(
                  DateTimeFormatter.ofPattern(DolarApplication.PATTERN_MM_DD_YYYY));
        
        given()
          .when()
          .queryParam(DolarRest.QUERY_PARAM_DOLAR, dataIncorretaFormato)
          .get(DolarRest.PATH_COTACAO_DOLAR)
          .then()
             .statusCode(400);
    }
    
}
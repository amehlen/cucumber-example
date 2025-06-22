package de.axa.cucumber_example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import io.cucumber.java.de.Gegebensei;
import io.restassured.response.Response;

public class LifeInsuranceStepDefs {

  private Response offerResponse;
  private Response applicationResponse;
  private Long offerId;

  @Wenn("ich ein Angebot für das Produkt {string} mit einer Laufzeit von {int} Jahren anfordere")
  public void ichFordereEinAngebotAn(String product, int duration) {
    offerResponse = given()
        .queryParam("product", product)
        .queryParam("duration", duration)
        .when()
        .get("http://localhost:8080/offer");
  }

  @Dann("erhalte ich ein Angebot mit einem Beitrag größer als 0")
  public void erhalteIchEinAngebot() {
    offerResponse.then().statusCode(200);
    double contribution = offerResponse.jsonPath().getDouble("contribution");
    assertThat(contribution, greaterThan(0.0));
  }

  @Gegebensei("ein Angebot für das Produkt {string} mit einer Laufzeit von {int} Jahren")
  public void seiEinAngebotVorhanden(String product, int duration) {
    offerResponse = given()
        .queryParam("product", product)
        .queryParam("duration", duration)
        .when()
        .get("http://localhost:8080/offer");
    offerId = offerResponse.jsonPath().getLong("id");
  }

  @Wenn("ich einen Antrag für {string} auf dieses Angebot stelle")
  public void ichStelleEinenAntrag(String name) {
    applicationResponse = given()
        .queryParam("offerId", offerId)
        .queryParam("policyHolder", name)
        .post("http://localhost:8080/application");
  }

  @Dann("sollte der Antrag den Status {string} haben")
  public void antragStatusPrüfen(String status) {
    applicationResponse.then().statusCode(200);
    String responseStatus = applicationResponse.jsonPath().getString("state");
    assertThat(responseStatus, equalTo(status));
  }

}

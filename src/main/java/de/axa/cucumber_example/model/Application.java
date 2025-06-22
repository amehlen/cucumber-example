package de.axa.cucumber_example.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String policyHolder;

  @ManyToOne(cascade = CascadeType.ALL)
  private Offer offer;

  private String state; // z. B. "EINGEREICHT", "GENEHMIGT"

  public Application() {
  }

  public Application(String policyHolder, Offer offer, String state) {
    this.policyHolder = policyHolder;
    this.offer = offer;
    this.state = state;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPolicyHolder() {
    return policyHolder;
  }

  public void setPolicyHolder(String policyHolder) {
    this.policyHolder = policyHolder;
  }

  public Offer getOffer() {
    return offer;
  }

  public void setOffer(Offer offer) {
    this.offer = offer;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}

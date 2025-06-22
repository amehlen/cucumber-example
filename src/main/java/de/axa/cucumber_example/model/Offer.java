package de.axa.cucumber_example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Offer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String product;
  private int duration;
  private double contribution;
  private double insuredSum;

  public Offer() {
  }

  public Offer(String product, int duration, double contribution, double insuredSum) {
    this.product = product;
    this.duration = duration;
    this.contribution = contribution;
    this.insuredSum = insuredSum;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public double getContribution() {
    return contribution;
  }

  public void setContribution(double contribution) {
    this.contribution = contribution;
  }

  public double getInsuredSum() {
    return insuredSum;
  }

  public void setInsuredSum(double insuredSum) {
    this.insuredSum = insuredSum;
  }

}

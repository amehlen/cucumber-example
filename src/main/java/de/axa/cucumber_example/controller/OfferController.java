package de.axa.cucumber_example.controller;

import de.axa.cucumber_example.model.Offer;
import de.axa.cucumber_example.services.OfferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offer")
public class OfferController {

  private final OfferService offerService;

  public OfferController(OfferService offerService) {
    this.offerService = offerService;
  }

  @GetMapping
  public Offer getOffer(@RequestParam String product, @RequestParam int duration) {
    return offerService.calculateAndSaveOffer(product, duration);
  }

}

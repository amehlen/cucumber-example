package de.axa.cucumber_example.services;

import de.axa.cucumber_example.model.Offer;
import de.axa.cucumber_example.repository.OfferRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

  private final OfferRepository offerRepository;

  public OfferService(OfferRepository offerRepository) {
    this.offerRepository = offerRepository;
  }

  public Offer calculateAndSaveOffer(String product, int duration) {
    double beitrag = duration * 10.5;
    double summe = beitrag * 20;
    Offer offer = new Offer(product, duration, beitrag, summe);
    return offerRepository.save(offer);
  }

  public Optional<Offer> findOffer(Long id) {
    return offerRepository.findById(id);
  }

}

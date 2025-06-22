package de.axa.cucumber_example.services;

import de.axa.cucumber_example.model.Application;
import de.axa.cucumber_example.model.Offer;
import de.axa.cucumber_example.repository.ApplicationRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

  private final ApplicationRepository applicationRepository;

  public ApplicationService(ApplicationRepository applicationRepository) {
    this.applicationRepository = applicationRepository;
  }

  public Application erfasseAntrag(String name, Offer offer) {
    Application application = new Application(name, offer, "EINGEREICHT");
    return applicationRepository.save(application);
  }

  public Optional<Application> getStatus(Long id) {
    return applicationRepository.findById(id);
  }

}

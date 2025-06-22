package de.axa.cucumber_example.controller;

import de.axa.cucumber_example.model.Application;
import de.axa.cucumber_example.services.ApplicationService;
import de.axa.cucumber_example.services.OfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController {

  private final OfferService offerService;
  private final ApplicationService applicationService;

  public ApplicationController(OfferService offerService, ApplicationService applicationService) {
    this.offerService = offerService;
    this.applicationService = applicationService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Application> getApplicationState(@PathVariable Long id) {
    return applicationService.getState(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Application> createNewApplication(@RequestParam Long applicationId,
      @RequestParam String policyHolder) {
    return offerService.findOffer(applicationId)
        .map(application -> ResponseEntity.ok(applicationService.captureApplication(policyHolder, application)))
        .orElse(ResponseEntity.notFound().build());
  }

}

package tn.esprit.SkiStationProject.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import tn.esprit.SkiStationProject.entities.Subscription;
import tn.esprit.SkiStationProject.entities.enums.TypeSubscription;


public interface ISubscriptionServices {

	Subscription addSubscription(Subscription subscription);

	Subscription updateSubscription(Subscription subscription);

	Subscription retrieveSubscriptionById(Long numSubscription);

	Set<Subscription> getSubscriptionByType(TypeSubscription type);

	List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);

	List<Subscription> retrieveSubscriptions();
}

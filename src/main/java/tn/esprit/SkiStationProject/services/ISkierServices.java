package tn.esprit.SkiStationProject.services;

import tn.esprit.SkiStationProject.entities.Skier;
import tn.esprit.SkiStationProject.entities.enums.TypeSubscription;

import java.util.List;

public interface ISkierServices {

	List<Skier> retrieveAllSkiers();

	Skier  addSkier(Skier  skier);

	Skier assignSkierToSubscription(Long numSkier, Long numSubscription);

	Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);

	void removeSkier (Long numSkier);

	Skier retrieveSkier (Long numSkier);


	Skier assignSkierToPiste(Long numSkieur, Long numPiste);

	List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription);

}

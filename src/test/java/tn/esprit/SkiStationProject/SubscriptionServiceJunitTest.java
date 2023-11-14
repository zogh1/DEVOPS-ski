package tn.esprit.SkiStationProject;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.SkiStationProject.entities.Course;
import tn.esprit.SkiStationProject.entities.Subscription;
import tn.esprit.SkiStationProject.repositories.SubscriptionRepository;
import tn.esprit.SkiStationProject.services.ISubscriptionServices;

import java.time.LocalDate;

import static tn.esprit.SkiStationProject.entities.enums.TypeSubscription.ANNUAL;
import static tn.esprit.SkiStationProject.entities.enums.TypeSubscription.MONTHLY;

@TestMethodOrder(OrderAnnotation.class)
public class SubscriptionServiceJunitTest {

    @Mock
    ISubscriptionServices SubscriptionServices;

    @InjectMocks
    SubscriptionRepository SubscriptionRepository;

    LocalDate date1=LocalDate.parse("2023-02-13");
    LocalDate date2=LocalDate.parse("2024-01-13");
    LocalDate date3=LocalDate.parse("2020-05-01");
    LocalDate date4=LocalDate.parse("2023-06-20");
    Subscription s1 = new Subscription(date1,date2,5.5f,ANNUAL);
    Subscription s2 = new Subscription( date3,date4,7.5f,MONTHLY);

    @Test
    @Order(1)
    public void testaddProdiut() {
        Subscription SubscriptionAdded = SubscriptionServices.addSubscription(s1);
        Assertions.assertEquals(SubscriptionAdded.getStartDate(), SubscriptionAdded.getEndDate());
    }

    @Test
    @Order(2)
    public void testRetrieveAllSubscriptions() {
        List<Subscription> listSubscriptions = SubscriptionServices.retrieveSubscriptions();
        Assertions.assertEquals(listSubscriptions.size(), listSubscriptions.size());
    }

   /* @Order(3)
    @Test
    public void testRetrieveUser() {
        Subscription SubscriptionRetrieved = SubscriptionService.retrieveSubscription(1L);
        Assertions.assertEquals(1L, SubscriptionRetrieved.getIdSubscription().longValue());
    }*/

    @Test

    @Order(3)
    public void testModifySubscription()   {

        Subscription SubscriptionUpdated  = SubscriptionServices.updateSubscription(s2);
        Assertions.assertEquals(s2.getStartDate(), SubscriptionUpdated.getStartDate());
    }

    @Test

    @Order(2)
    public void testDeleteSubscription() {

        //  SubscriptionService.deleteSubscription(6L);
        SubscriptionRepository.deleteAll();
        Assertions.assertNull(SubscriptionServices.retrieveSubscriptionById(1L));

    }


}

package tn.esprit.SkiStationProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.SkiStationProject.entities.Course;
import tn.esprit.SkiStationProject.entities.Registration;
import tn.esprit.SkiStationProject.entities.enums.Support;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {

    long countByCourseAndNumWeek(Course course, int numWeek);
    @Query("select reg.numWeek " +
            "from Registration reg " +
            "join Instructor ins " +
            "on reg.course member ins.courses " +
            "where ins.id = :idIns and reg.course.support = :support")
    List<Integer> numWeeksCourseOfInstructorBySupport(@Param("idIns") Long numInstructor, @Param("support") Support support);

    @Query("select count(distinct r) from Registration r " +
            "where r.numWeek = ?1 and r.skier.id = ?2 and r.course.id = ?3")
    long countDistinctByNumWeekAndSkier_NumSkierAndCourse_NumCourse(int numWeek, Long numSkier, Long numCourse);


}

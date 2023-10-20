package BuilderDesignPattern;

import org.testng.annotations.Test;

public class StudentTest {

    Student student = new StudentBuilder(1, "Stefana", "Bradas").build();
    Student student2 = new StudentBuilder(1, "Stefana", "Bradas").setPassedAllExams(true).setGraduated(false).build();



    @Test
    public void proba() {
        System.out.println(student);
        System.out.println(student2);
    }



}

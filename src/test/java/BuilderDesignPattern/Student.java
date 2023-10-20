package BuilderDesignPattern;

import lombok.Getter;
import lombok.NonNull;
import tests.User;

@Getter
public class Student{

    //REQUIRED PARAMETERS
    private int id;
    private String firstName;
    private String lastName;

    //OPTIONAL PARAMETERS
    private String indexNum;
    private boolean passedAllExams;
    private boolean graduated;

    protected Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.firstName = studentBuilder.firstName;
        this.lastName = studentBuilder.lastName;
        this.indexNum = studentBuilder.indexNum;
        this.passedAllExams = studentBuilder.passedAllExams;
        this.graduated = studentBuilder.graduated;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", indexNum='" + indexNum + '\'' +
                ", passedAllExams=" + passedAllExams +
                ", graduated=" + graduated +
                '}';
    }
}

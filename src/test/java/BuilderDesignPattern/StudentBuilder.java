package BuilderDesignPattern;

public class StudentBuilder {


    //REQUIRED PARAMETERS
    protected int id;
    protected String firstName;
    protected String lastName;


    //OPTIONAL PARAMETERS
    protected String indexNum;
    protected boolean passedAllExams;
    protected boolean graduated;


    public StudentBuilder () {}

    public StudentBuilder(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public StudentBuilder setPassedAllExams(boolean passedAllExams) {
        this.passedAllExams = passedAllExams;
        return this;
    }

    public StudentBuilder setGraduated(boolean graduated) {
        this.graduated = graduated;
        return this;
    }

    public Student build() {
        return new Student(this);
    }


}

package mk.ukim.finki.wp.lab.model.exceptions;

public class StudentOrCourseNotFound extends RuntimeException{
    public StudentOrCourseNotFound()
    {
        super("Student or Course do not exist");
    }
}

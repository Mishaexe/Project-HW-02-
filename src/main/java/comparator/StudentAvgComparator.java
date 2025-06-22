package comparator;

import model.Student;

public class StudentAvgComparator implements StudentComparator{
    @Override
    public int compare(Student d1, Student d2) {
        return Double.compare(d2.getAvgExamScore(), d1.getAvgExamScore());
    }
}

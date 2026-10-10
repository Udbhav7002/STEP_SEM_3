public class Problem8_StudentGradeAssignment {

    static class StudentGradeAssignment {
        public void assignGrade(int marks) {
            char grade;
            if (marks >= 90) grade = 'A';
            else if (marks >= 75) grade = 'B';
            else if (marks >= 60) grade = 'C';
            else if (marks >= 40) grade = 'D';
            else grade = 'F';
            System.out.println("Grade " + grade);
        }
    }

    public static void main(String[] args) {
        StudentGradeAssignment sga = new StudentGradeAssignment();
        sga.assignGrade(72);
        sga.assignGrade(95);
        sga.assignGrade(35);
        System.out.println("---");
        sga.assignGrade(89);
        sga.assignGrade(60);
        sga.assignGrade(40);
    }
}
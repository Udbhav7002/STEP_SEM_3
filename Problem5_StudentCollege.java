public class Problem5_StudentCollege {

    static class Student {
        private static String collegeName = "SRM Institute of Science and Technology";
        private static int studentCount = 0;

        private final String name;
        private final int attendance;

        public Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Total students: " + studentCount);
        }
    }

    public static void main(String[] args) {
        new Student("Alice", 90);
        new Student("Bob", 85);

        Student.printCollegeInfo();
    }
}
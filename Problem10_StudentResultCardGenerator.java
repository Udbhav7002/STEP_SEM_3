public class Problem10_StudentResultCardGenerator {

    static class Student {
        private String name;
        private int[] marks;

        public Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        public double getAverage() {
            int sum = 0;
            for (int m : marks) sum += m;
            return (double) sum / marks.length;
        }

        public char getGrade(double average) {
            if (average >= 75) return 'B';
            else if (average >= 60) return 'A'; // assuming A for 75+
            else if (average >= 40) return 'D';
            else return 'F';
        }

        public void printResultCard() {
            double avg = getAverage();
            char grade = getGrade(avg);
            System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), avg, grade);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Asha", new int[]{80, 90, 70});
        Student s2 = new Student("Ravi", new int[]{60, 55, 50});
        s1.printResultCard();
        s2.printResultCard();
        System.out.println("---");
        Student s3 = new Student("Priya", new int[]{95, 92, 98});
        Student s4 = new Student("Rahul", new int[]{30, 35, 40});
        s3.printResultCard();
        s4.printResultCard();
    }
}
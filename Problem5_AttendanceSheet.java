public class Problem5_AttendanceSheet {

    static class AttendanceSheet {
        private final int maxSize;
        private final String[] presentStudents;
        private int count;

        public AttendanceSheet(int maxSize) {
            this.maxSize = maxSize;
            this.presentStudents = new String[maxSize];
            this.count = 0;
        }

        public void markPresent(String name) {
            if (count >= maxSize) {
                return;
            }
            for (int i = 0; i < count; i++) {
                if (presentStudents[i].equals(name)) {
                    return;
                }
            }
            presentStudents[count] = name;
            count++;
        }

        public int getPresentCount() {
            return count;
        }

        public boolean isPresent(String name) {
            for (int i = 0; i < count; i++) {
                if (presentStudents[i].equals(name)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
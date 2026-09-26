package week_7.encapsulation.class_problems;

public class AttendanceSheet {
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
package week_7.encapsulation.class_problems;

public class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combination.equals(currentCode)) {
            combination = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}
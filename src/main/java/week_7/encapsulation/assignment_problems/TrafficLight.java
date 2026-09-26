package week_7.encapsulation.assignment_problems;

public class TrafficLight {
    private final String id;
    private String currentColor;

    public TrafficLight(String id) {
        this.id = id;
        this.currentColor = "RED";
    }

    public void next() {
        switch (currentColor) {
            case "RED":
                currentColor = "GREEN";
                break;
            case "GREEN":
                currentColor = "YELLOW";
                break;
            case "YELLOW":
                currentColor = "RED";
                break;
        }
    }

    public String getColor() {
        return currentColor;
    }

    public String getId() {
        return id;
    }
}
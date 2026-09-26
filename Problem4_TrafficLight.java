public class Problem4_TrafficLight {

    static class TrafficLight {
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

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Initial: " + t.getColor());
        t.next();
        System.out.println("After next: " + t.getColor());
        t.next();
        System.out.println("After next: " + t.getColor());
        t.next();
        System.out.println("After next: " + t.getColor());
    }
}
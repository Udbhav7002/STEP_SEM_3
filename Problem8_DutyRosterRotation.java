public class Problem8_DutyRosterRotation {

    static class DutyRosterRotation {
        public String[] rotateRoster(String[] names, int k) {
            int n = names.length;
            k = k % n;
            if (k == 0) return names.clone();
            String[] result = new String[n];
            for (int i = 0; i < n; i++) {
                result[(i + k) % n] = names[i];
            }
            return result;
        }

        public void printRoster(String[] roster) {
            System.out.print("[");
            for (int i = 0; i < roster.length; i++) {
                System.out.print(roster[i]);
                if (i < roster.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        DutyRosterRotation drr = new DutyRosterRotation();
        String[] names = {"A", "B", "C", "D", "E"};
        drr.printRoster(drr.rotateRoster(names, 2)); // Expected: [D, E, A, B, C]
        drr.printRoster(drr.rotateRoster(names, 7)); // Expected: [D, E, A, B, C]
        System.out.println("---");
        drr.printRoster(drr.rotateRoster(names, 0)); // Expected: [A, B, C, D, E]
        drr.printRoster(drr.rotateRoster(names, 5)); // Expected: [A, B, C, D, E]
        drr.printRoster(drr.rotateRoster(new String[]{"X", "Y"}, 3)); // Expected: [Y, X]
    }
}
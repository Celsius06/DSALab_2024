public class Problem_1 {
    public int puzzle(int base, int limit) {
        // Assume that base and limit are nonnegative numbers
        // Base case 1
        if (base > limit) {
            return -1;
        }
        // Base case 2
        else if (base == limit) {
            return 1;
        } else {
            // Recursive case
            // if (base < limit)
            return base * puzzle (base + 1, limit);
        }
    }

    public static void main (String[] args) {
        Problem_1 p1 = new Problem_1();
        // a. System.out.print(puzzle((14, 10));
        System.out.print("Output for a = ");
        System.out.println(p1.puzzle(14, 10));

        // b. System.out.print(puzzle(4, 7));
        System.out.print("Output for b = ");
        System.out.println(p1.puzzle(4, 7));

        // c. System.out.print(puzzle(0, 0));
        System.out.print("Output for c = ");
        System.out.println(p1.puzzle(0, 0));
    }
}

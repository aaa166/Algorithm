import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Passenger {
        int row, baggage = 5, pos = 0;
        boolean seated = false;
        public Passenger(int r) { this.row = r; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            passengers.add(new Passenger(Integer.parseInt(br.readLine())));
        }

        int time = 0;
        int seatedCount = 0;

        while (seatedCount < n) {
            time++;
            for (int i = 0; i < n; i++) {
                Passenger p = passengers.get(i);
                if (p.seated) continue;

                if (p.pos == p.row) {
                    p.baggage--;
                    if (p.baggage == 0) {
                        p.seated = true;
                        seatedCount++;
                    }
                }
                else {
                    boolean canMove = true;
                    if (i > 0) {
                        Passenger front = passengers.get(i - 1);
                        if (!front.seated && front.pos <= p.pos + 1) {
                            canMove = false;
                        }
                    }
                    if (canMove) p.pos++;
                }
            }
        }
        System.out.println(time);
    }
}
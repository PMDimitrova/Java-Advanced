package TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TrafficLight[] trafficLights = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .toArray(TrafficLight[]::new);

        int n = Integer.parseInt(scan.nextLine());
        TrafficLight[] lights = TrafficLight.values();
        while (n-- > 0) {
            for (int i = 0; i < trafficLights.length; i++) {
                TrafficLight trafficLight = trafficLights[i];
                int next = trafficLight.ordinal() + 1;
                trafficLights[i] = lights[next % lights.length];
                System.out.print(trafficLights[i] + " ");
            }
            System.out.println();
        }
    }
}

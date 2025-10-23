package utils;

public class DistanceCalculator {

    /**
     * Fallback distance calculation (no Google API used).
     * This returns a random distance between 5–25 km.
     */
    public static double calculateDistance(String origin, String destination) {
        // Fake distance between 5 and 25 km
        double distanceKm = 5 + (Math.random() * 20);
        System.out.println("DEBUG (Fallback): Fake distance between " + origin + " and " + destination + " = " + distanceKm + " km");
        return distanceKm;
    }

    /**
     * Simple fare calculation — multiply distance × rate.
     */
    public static double calculateFare(double distance, double perKmRate) {
        double baseFare = 20; // optional base fare
        double total = baseFare + (distance * perKmRate);
        System.out.println("DEBUG (Fallback): Fare calculated = ₹" + total);
        return total;
    }
}

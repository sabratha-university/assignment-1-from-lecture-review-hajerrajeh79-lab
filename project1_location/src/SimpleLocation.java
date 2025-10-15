public class SimpleLocation {

    protected double latitude;
    protected double longitude;

    public SimpleLocation(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public double distance(SimpleLocation other) {
        return distance(this.latitude, this.longitude, other.latitude, other.longitude);
    }

    public double distance(double lat2, double lon2) {
        return distance(this.latitude, this.longitude, lat2, lon2);
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371.0;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }

    public static void main(String[] args) {
        SimpleLocation myLocation = new SimpleLocation(32.7922, 12.4847);
        SimpleLocation college = new SimpleLocation(32.7639, 12.7367);

        System.out.printf("Distance (by object): %.3f km%n", myLocation.distance(college));
        System.out.printf("Distance (by coordinates): %.3f km%n", myLocation.distance(32.7639, 12.7367));

        NamedLocation sebrata = new NamedLocation("Sebrata", 32.7922, 12.4847);
        NamedLocation itCollege = new NamedLocation("IT College", 32.7639, 12.7367);

        System.out.println("\nUsing Overriding (toString method):");
        System.out.println(sebrata);
        System.out.println(itCollege);
    }
}

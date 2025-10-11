public class NamedLocation extends SimpleLocation {

    private String name;

    public NamedLocation(String name, double lat, double lon) {
        super(lat, lon);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + latitude + ", " + longitude + ")";
    }
}

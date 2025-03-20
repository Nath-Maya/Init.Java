import java.util.ArrayList;
import java.util.List;

public class RealEstateAgency {
    private List<Property> properties;

    public RealEstateAgency() {
        this.properties = new ArrayList<>();
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void showAllProperties() {
        for (Property property : properties) {
            property.showInfo();
        }
    }
}
import java.util.HashMap;

class SpaceAge {

    double seconds;
    private final HashMap<String, Double> age = new HashMap<>();

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double onEarth() {
        if (!age.containsKey("onEarth")) age.put("onEarth", seconds / 60.0D / 60.0D / 24D / 365.25D);
        return age.get("onEarth");
    }

    double onMercury() {
        if (!age.containsKey("onMercury")) age.put("onMercury", onEarth() / 0.2408467D);
        return age.get("onMercury");
    }

    double onVenus() {
        if (!age.containsKey("onVenus")) age.put("onVenus", onEarth() / 0.61519726D);
        return age.get("onVenus");
    }

    double onMars() {
        if (!age.containsKey("onMars")) age.put("onMars", onEarth() / 1.8808158D);
        return age.get("onMars");
    }

    double onJupiter() {
        if (!age.containsKey("onJupiter")) age.put("onJupiter", onEarth() / 11.862615D);
        return age.get("onJupiter");
    }

    double onSaturn() {
        if (!age.containsKey("onSaturn")) age.put("onSaturn", onEarth() / 29.447498D);
        return age.get("onSaturn");
    }

    double onUranus() {
        if (!age.containsKey("onUranus")) age.put("onUranus", onEarth() / 84.016846D);
        return age.get("onUranus");
    }

    double onNeptune() {
        if (!age.containsKey("onNeptune")) age.put("onNeptune", onEarth() / 164.79132D);
        return age.get("onNeptune");
    }
}

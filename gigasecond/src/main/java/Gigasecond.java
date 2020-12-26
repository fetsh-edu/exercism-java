import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Gigasecond {

    private final LocalDateTime gigasecond;

    public Gigasecond(LocalDate moment) {
        this.gigasecond = addGigasecond(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        this.gigasecond = addGigasecond(moment);
    }

    public LocalDateTime getDateTime() {
        return gigasecond;
    }

    private LocalDateTime addGigasecond(LocalDateTime ldt){
        return ldt.plus(1000000000, ChronoUnit.SECONDS);
    }
}

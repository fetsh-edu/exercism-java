import java.time.DayOfWeek;
import java.time.LocalDate;

public class Meetup {

    private final int month;
    private final int year;

    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
        var startDate = LocalDate.of(year, month, 1);
        var stream = startDate
                .datesUntil(startDate.plusMonths(1))
                .filter(d -> d.getDayOfWeek().equals(dayOfWeek));

        return switch (meetupSchedule) {
            // case FIRST, SECOND, THIRD, FOURTH -> stream.skip(meetupSchedule.ordinal()).findFirst().get();
            // Nope. Don't like to rely on ordinal()
            //
            case FIRST -> stream.findFirst().get();
            case SECOND -> stream.skip(1).findFirst().get();
            case THIRD -> stream.skip(2).findFirst().get();
            case FOURTH -> stream.skip(3).findFirst().get();
            case LAST -> stream.reduce((a, b) -> b).get();
            case TEENTH -> stream.filter(d -> d.getDayOfMonth() > 12 && d.getDayOfMonth() < 20).findFirst().get();
        };
    }
}
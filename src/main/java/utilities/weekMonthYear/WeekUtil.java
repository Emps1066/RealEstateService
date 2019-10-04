package utilities.weekMonthYear;

public class WeekUtil {
    private static final double WEEKS_IN_MONTH = 4;
    private static final double WEEKS_IN_YEAR = 52;
    public String toString(double weeks) {
        StringBuilder duration = new StringBuilder();
        if(weeks >= WEEKS_IN_YEAR) {
            duration.append(String.format("%.2f years", weeks/WEEKS_IN_YEAR));
        } else if(weeks >= WEEKS_IN_MONTH) {
            duration.append(String.format("%.2f months", weeks/WEEKS_IN_MONTH));
        } else {
            duration.append(String.format("%.2f weeks", weeks));
        }

        return duration.toString();
    }
}

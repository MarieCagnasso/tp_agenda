package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {

    private ArrayList<LocalDate> exceptions;

    private ChronoUnit frequency;
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
        this.exceptions = new ArrayList<>();
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        exceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;
    }

    public ArrayList<LocalDate> getExceptions() {
        return exceptions;
    }

    @Override
    public boolean isInDay(LocalDate aDay) {
        if (exceptions.contains(aDay)) {
            return false;
        }

        LocalDate date = this.getStart().toLocalDate();

        while(date.isBefore(aDay) ){
            date = date.plus(1,this.frequency);
        }

        return aDay.equals(date);

    }




}

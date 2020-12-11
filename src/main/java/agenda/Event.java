package agenda;

import java.time.*;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;
    
    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private Duration myDuration;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        LocalDate dateStart= this.myStart.toLocalDate();
        LocalDate dateFin = this.myStart.plus(myDuration).toLocalDate();
        return aDay.isAfter(dateStart.minusDays(1)) && aDay.isBefore(dateFin.plusDays(1));
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDateTime aDay) {
        return aDay.equals(myStart) || aDay.equals(myStart.plus(myDuration)) || aDay.isAfter(this.myStart) && aDay.isBefore(this.myStart.plus(myDuration));

        // POUR DEBUG
       /* LocalDateTime fin = myStart.plus(myDuration);
        if(aDay.equals(myStart)){
            return true;
        }
        if(aDay.equals(fin)){
            return true;
        }
        if (aDay.isAfter(this.myStart)){
            if (aDay.isBefore(fin)){
                return true;
            }
        }
        return false;*/
    }
   
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    public String toString(){
        return "L'évènement " + getTitle() + " commence le "+ getStart() +" et dure "+getDuration()+".";
    }

   
    
}

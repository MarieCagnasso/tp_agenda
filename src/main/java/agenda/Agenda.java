package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    private ArrayList<Event> evenements;

    public Agenda (){
        evenements = new ArrayList<>();
    }
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        evenements.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List list = new ArrayList();
        for (Event e: evenements){
            if (e.isInDay(day)){
                list.add(e);
        } }
        return list;
    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        List<Event> list = new ArrayList<>();
        for (Event e: evenements){
            if(e.getTitle().equals(title)){
                list.add(e);
            }
        }
        return list;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        boolean rep = true;
        for (Event event: evenements){
            if (event.isInDay(e.getStart()) || event.isInDay(e.getStart().plus(e.getDuration())) || e.isInDay(event.getStart())){
                rep = false;
                break;
            }
        }
        return rep;
    }

    public void viderAgenda(){
        this.evenements.clear();
    }
}

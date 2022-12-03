package A4_Flights;

import static A4_Flights.Common.AVERAGE_PERSON_WEIGHT;

/**
 * Flight - a nonstop flight departing from the home airport Flight is the
 * parent class for Training, Cargo, and Passenger Flights
 */
public abstract class Flight implements PolicyRules {

    // TODO-A1 - Complete this class, using javadocs as a reference
    //declare fields
    private String flightNumber;
    private String dayOfWeek;
    private int departureTime;
    private Location destination;
    private int numCrew;

    //implement four methods in the appropriate classes (INTERFACE)
    @Override
    public boolean checkCrew() {
        //Does the flight have the required minimum number of crew members?
        //return true if so
        return numCrew >= Common.MINIMUM_CREW;
    }

    @Override
    public boolean checkPassengers() {
        //Does the flight have the required minimum number of passengers?
        //MINIMUM_PASSENGERS
        return true;
    }

    @Override
    public boolean checkTime() {
        //Does the flight have an acceptable departure time?
        return true;
    }

    public boolean checkWeight() {
        //Does the flight have an acceptable total weight?
        return true;
    }

    //constructors
    public Flight(String flightNumber, String dayOfWeek, int departureTime, Location destination, int numCrew) {
        this.flightNumber = flightNumber;
        this.dayOfWeek = dayOfWeek;
        this.departureTime = departureTime;
        this.destination = destination;
        this.numCrew = numCrew;
    }

    public int calculateWeight() {
        //public static final int AVERAGE_PERSON_WEIGHT = 75;
        int weight = getNumCrew() * AVERAGE_PERSON_WEIGHT;
        return weight;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public Location getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    abstract String getFlightType();

    public int getNumCrew() {
        return numCrew;
    }

    public String toDisplayReport() {
        //Creates a string containing detailed information about this flight.
        String res = getFlightType() + "=" + getFlightNumber() + ", Day=" + getDayOfWeek() + ", Time=" + getDepartureTime() + "\n\t" + "Destination: " + getDestination().toDisplayFormat() + "\n\t" + "Number of Crew: " + getNumCrew()
                + "\n\t" + "Total Weight: " + calculateWeight();
        return res;
    }

    public String toArchiveFormat() {
        //Creates a string containing information about this flight in a format 
        //suitable for archiving in a text file.
        // Training,QR97,Sun,1215,BAH,4,
        // Cargo,QR30,Sun,545,BKK,10,38352
        //Passenger,QR100,Sun,1715,BKK,1,241
        String res = getFlightType() + ", " + getFlightNumber() + ", " + getDayOfWeek() + ", " + getDepartureTime()
                + ", " + getDestination().getLocationCode() + ", " + getNumCrew();
        return res;
    }

} // end class Flight

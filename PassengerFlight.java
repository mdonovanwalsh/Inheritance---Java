package A4_Flights;

import static A4_Flights.Common.AVERAGE_PERSON_WEIGHT;

/**
 * A passenger flight has no cargo
 */
public class PassengerFlight extends Flight {

    // TODO-A3 - Complete this class, using javadocs as a reference
    //fields
    private int numPassengers;

    @Override
    public boolean checkPassengers() {
        //Does the flight have the required minimum number of passengers?
        //MINIMUM_PASSENGERS
        if (numPassengers >= Common.MINIMUM_PASSENGERS) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean checkWeight() {
        //Does the flight have an acceptable total weight?
        return (calculateWeight() <= Common.MAXIMUM_WEIGHT);
    }

    //constructor
    public PassengerFlight(String flightNumber, String dayOfWeek, int departureTime, Location destination, int numCrew, int numPassengers) {
        super(flightNumber, dayOfWeek, departureTime, destination, numCrew);
        this.numPassengers = numPassengers;
    }

    //methods
    @Override
    public int calculateWeight() {
        //Calculates the weight of this flight as the weight of the crew members
        //this method should add the weight of the passengers to the weight of the crew
        int weight = super.calculateWeight() + (numPassengers * AVERAGE_PERSON_WEIGHT);
        return weight;
    }

    @Override
    public String getFlightType() {
        //Gets the flight type of this flight - child classes must implement
        return "Passenger";
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    @Override
    public String toDisplayReport() {
        //Creates a string containing detailed information about this flight.
        //this method should add to string produced by Flight class (add cargoWeight and total weight)
        return super.toDisplayReport();
//                + "\n\t" + "Total Weight: " + calculateWeight();
    }

    @Override
    public String toArchiveFormat() {
        //Creates a string containing information about this flight in a format 
        //suitable for archiving in a text file.
        //this method should add numPassengers to string produced 
        return super.toArchiveFormat() + ", " + numPassengers;
    }

} // end class PassengerFlight

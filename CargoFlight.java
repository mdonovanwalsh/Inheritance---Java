package A4_Flights;

import static A4_Flights.Common.AVERAGE_PERSON_WEIGHT;

/**
 * Cargo inherits from Flight Cargo flights have crew, cargo, but no passengers
 */
public class CargoFlight extends Flight {

    // TODO-A2 - Complete this class, using javadocs as a reference
    //fields
    private int cargoWeight;

    @Override
    public boolean checkWeight() {
        //Does the flight have an acceptable total weight?
        return (calculateWeight() <= Common.MAXIMUM_WEIGHT);
    }

    //constructor
    public CargoFlight(String flightNumber, String dayOfWeek, int departureTime, Location destination, int numCrew, int cargoWeight) {
        super(flightNumber, dayOfWeek, departureTime, destination, numCrew); //call constructor from Flight class
        this.cargoWeight = cargoWeight;
    }

    public int calculateWeight() {
        //Calculates the weight of this flight as the weight of the crew members
        //this method should add the weight of the cargo to the weight of the crew
        int weight = super.calculateWeight() + (int) getCargoWeight();
        return weight;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    @Override
    public String getFlightType() {
        //Gets the flight type of this flight - child classes must implement
        String cargo = "Cargo";
        return cargo;
    }

    @Override
    public String toDisplayReport() {
        //Creates a string containing detailed information about this flight.
        //this method should add to string produced by Flight class (add cargoWeight and total weight)
        return super.toDisplayReport();
        //"\n\t" + "Total Weight: " + calculateWeight();
    }

    @Override
    public String toArchiveFormat() {
        //Creates a string containing information about this flight in a format 
        //suitable for archiving in a text file.
        //this method should add to string produced by Flight class (add cargoWeight and total weight)
        return super.toArchiveFormat() + ", " + (int) getCargoWeight();
    }

} // end class CargoFlight

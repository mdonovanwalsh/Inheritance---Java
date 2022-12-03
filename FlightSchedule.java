package A4_Flights;

import java.util.ArrayList;

public class FlightSchedule {

    private final Flight[] flights;

    /**
     * Creates a new schedule based on the specified flights.
     *
     * @param flights the flights to be contained in this schedule
     */
    public FlightSchedule(Flight[] flights) {
        this.flights = flights;
    }

    /**
     * Gets all of the flights in this schedule.
     *
     * @return all of the flights in this schedule
     */
    public Flight[] getAllFlights() {
        return flights;
    }

    public Flight[] getFlightsByDestination(String locationCode) {
        // TODO-B1
        ArrayList<Flight> arrFlights = new ArrayList<Flight>();
        for (Flight fli : flights) {
            if (fli.getDestination().getLocationCode().equals(locationCode)) {
                arrFlights.add(fli);
            }
        }
        Flight[] allFlights = arrFlights.toArray(new Flight[0]);
        return allFlights;
//        return new Flight[0];
    }

    private int countFlightsByDestination(String locationCode) {
        int count = 0;
        for (Flight fli : flights) {
            if (fli.getDestination().getLocationCode().equals(locationCode)) {
                count++;
            }
        }
        // TODO-B1
        return count;
    }

    public Flight[] getFlightsByType(String flightType) {
        // TODO-B2
        ArrayList<Flight> arrFlightType = new ArrayList<Flight>();
        for (Flight fli : flights) {
            if (fli.getFlightType().equals(flightType)) {
                arrFlightType.add(fli);
            }
        }
        Flight[] allFlightTypes = arrFlightType.toArray(new Flight[0]);
        return allFlightTypes;
//        return new Flight[0];
    }

    private int countFlightsByType(String flightType) {
        // TODO-B2
        int count = 0;
        for (Flight fli : flights) {
            if (fli.getFlightType().equals(flightType)) {
                count++;
            }
        }
        // TODO-B1
        return count;
    }

} // end class FlightSchedule

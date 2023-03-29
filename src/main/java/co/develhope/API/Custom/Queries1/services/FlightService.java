package co.develhope.API.Custom.Queries1.services;

import co.develhope.API.Custom.Queries1.entities.Flight;
import co.develhope.API.Custom.Queries1.entities.Status;
import co.develhope.API.Custom.Queries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class FlightService {

    @Autowired
    public
    FlightRepository flightRepository;

    public String generateSring() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 9;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    public void provisioning() {
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription(generateSring());
            flight.setFromAirport(generateSring());
            flight.setStatus(Status.ON_TIME);
            flight.setToAirport(generateSring());
            flightRepository.save(flight);
        }

    }
    public List<Flight> getAllFlight(){
        return flightRepository.findAll();
    }

}

package one.digitalinnovation.cloud_parking.exception;

public class ParkingTrueException extends RuntimeException {
    public ParkingTrueException(String id) {
        super("Parkin with id: " + id);
    }
}

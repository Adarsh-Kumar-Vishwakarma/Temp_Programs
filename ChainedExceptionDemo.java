class NetworkException extends Exception {
    public NetworkException(String message) {
        super(message);
    }
}

class DataProcessingException extends Exception {
    public DataProcessingException(String message) {
        super(message);
    }
}

public class ChainedExceptionDemo {
    public static void main(String[] args) {
        try {
            fetchDataFromNetwork();
        } catch (NetworkException ne) {
            System.out.println("Caught NetworkException:");
            System.out.println("Exception message: " + ne.getMessage());
            if (ne.getCause() != null) {
                System.out.println("Chained Exception message: " + ne.getCause().getMessage());
            }
        }
    }
    
    public static void fetchDataFromNetwork() throws NetworkException {
        try {
            connectToNetwork();
        } catch (DataProcessingException dpe) {
            throw new NetworkException("Error while fetching data from the network" +dpe);
        }
    }
    
    public static void connectToNetwork() throws DataProcessingException {
        // Simulate a data processing issue
        throw new DataProcessingException("Error while processing data");
    }
}

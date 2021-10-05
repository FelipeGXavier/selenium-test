package ifc;

public class TicketEntity {

    private final String ticketLevel;
    private final double ticketPrice;
    private final int ticketQuantity;

    public TicketEntity(String ticketLevel, double ticketPrice, int ticketQuantity) {
        this.ticketLevel = ticketLevel;
        this.ticketPrice = ticketPrice;
        this.ticketQuantity = ticketQuantity;
    }

    public String getTicketLevel() {
        return ticketLevel;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "ticketLevel='" + ticketLevel + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", ticketQuantity=" + ticketQuantity +
                '}';
    }
}

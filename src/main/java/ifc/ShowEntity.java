package ifc;

import java.util.List;

public class ShowEntity {

    private final String title;
    private final String cep;
    private final String description;
    private final String imageThumbnail;
    private final String startDate;
    private final String endDate;
    private final List<TicketEntity> tickets;

    protected ShowEntity(String title, String cep, String description, String imageThumbnail, String startDate, String endDate, List<TicketEntity> tickets) {
        this.title = title;
        this.cep = cep;
        this.description = description;
        this.imageThumbnail = imageThumbnail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tickets = tickets;
    }

    public String getTitle() {
        return title;
    }

    public String getCep() {
        return cep;
    }

    public String getDescription() {
        return description;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public List<TicketEntity> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return "ShowEntity{" +
                ", title='" + title + '\'' +
                ", cep='" + cep + '\'' +
                ", description='" + description + '\'' +
                ", imageThumbnail='" + imageThumbnail + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}

package ifc;

import java.util.List;

public class ShowEntityBuilder {

    private String title;
    private String cep;
    private String description;
    private String imageThumbnail;
    private String startDate;
    private String endDate;
    private List<TicketEntity> tickets;

    public ShowEntityBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ShowEntityBuilder setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public ShowEntityBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ShowEntityBuilder setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
        return this;
    }

    public ShowEntityBuilder setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public ShowEntityBuilder setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public ShowEntityBuilder setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
        return this;
    }

    public ShowEntity createShowEntity() {
        return new ShowEntity(title, cep, description, imageThumbnail, startDate, endDate, tickets);
    }
}
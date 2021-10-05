package ifc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StubInstanceCli {

    public void start() throws IOException {
        var scanner = new Scanner(System.in);
        System.out.println("Número de registros a serem gerados: ");
        int total = Integer.parseInt(scanner.nextLine());
        System.out.println("Nome do arquivo de saída: ");
        String fileName = scanner.nextLine();
        RandomStub generator = new RandomStub();
        StringBuilder result = new StringBuilder();
        String headers = "show;cep;description;thumbnail;start_date;end_date;tickets";
        result.append(headers).append("\n");
        for (int i = 0; i < total; i++) {
            var record = this.generateShowCsvLine(generator.getRandomShow());
            result.append(record).append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(result.toString());
        writer.close();
        new SeleniumExecutor().start(fileName);
    }

    private String generateShowCsvLine(ShowEntity entity) {
        String show = entity.getTitle() + ";" + entity.getCep() + ";" + entity.getDescription() + ";" + entity.getImageThumbnail() +
                ";" + entity.getStartDate() + ";" + entity.getEndDate() + ";";
        StringBuilder ticket = new StringBuilder();
        for (var ticketEntity : entity.getTickets()) {
            ticket.append(ticketEntity.getTicketLevel()).append(",").append(ticketEntity.getTicketQuantity()).append(",").append(ticketEntity.getTicketPrice()).append("|");
        }
        return show + ticket;
    }


}

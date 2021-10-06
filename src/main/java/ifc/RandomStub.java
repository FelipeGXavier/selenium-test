package ifc;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class RandomStub {

    private final String[] titles = {"Lorem ipsum dolor", "Proin at consectetur sem", "Curabitur leo nunc", "Morbi tempus libero", "Vestibulum malesuada molestie", "Nam vulputate dui",
            "Curabitur non augue ante", "Integer scelerisque interdum diam", "Vestibulum ante ipsum primis", "Maecenas at mauris justo"};

    private final String[] descriptions = {"Gostaria de enfatizar que a expansão dos mercados mundiais maximiza as possibilidades por conta dos relacionamentos verticais entre as hierarquias.", "Por outro lado, a mobilidade dos capitais internacionais faz parte de um processo de gerenciamento do fluxo de informações.", "Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se a percepção das dificuldades assume importantes posições no estabelecimento dos índices pretendidos.", "Assim mesmo, a competitividade nas transações comerciais promove a alavancagem de alternativas às soluções ortodoxas.", "Todavia, a revolução dos costumes estimula a padronização dos métodos utilizados na avaliação de resultados.", "Por outro lado, a valorização de fatores subjetivos afeta positivamente a correta previsão das novas proposições.", "Quando dizemos ao paciente que certa imagem sua significa outra coisa, o princípio suscetível que serve de base já está implícito no uso contemporâneo da interpretação transferencial da nostalgia da suposta presença da \"Coisa\" que teria nos salvado do desamparo.", "A pulsão é o elo entre o somático e o psíquico onde o inconsciente estruturado como linguagem é o ponto de fundação de nosso próprio desejo cujo o eu não é senhor em sua própria casa.", "Quando dizemos ao paciente que certa imagem sua significa outra coisa, o inconsciente estruturado como linguagem recusa a castração revelando-se por fim que o sofrimento em si mesmo é um gozo"};

    private final String[] ticketLevel = {"VIP", "Clássico", "Básico"};

    public ShowEntity getRandomShow() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String showTitle = this.titles[new Random().nextInt(this.titles.length)];
        String showDescription = this.descriptions[new Random().nextInt(this.descriptions.length)];
        int manyTickets = 1 + (int) (Math.random() * ((3 - 1) + 1));
        List<TicketEntity> tickets = new ArrayList<>();
        for (int i = 0; i < manyTickets; i++) {
            tickets.add(this.getRandomTicket());
        }
        var date = this.getRandomDate();
        return new ShowEntityBuilder()
                .setTitle(showTitle)
                .setDescription(showDescription)
                .setCep("18700480")
                .setImageThumbnail(new File(".").getCanonicalPath() + " \\default.png".trim())
                .setStartDate(date.format(formatter))
                .setEndDate(date.plusDays(6L).format(formatter))
                .setTickets(tickets)
                .createShowEntity();
    }


    private TicketEntity getRandomTicket() {
        Random r = new Random();
        int ticketQtd = 10 + (int) (Math.random() * ((1000 - 10) + 1));
        double ticketPrice = Math.floor(20.0 + r.nextDouble() * (200.0 - 20.0));
        String ticketLevel = this.ticketLevel[new Random().nextInt(this.ticketLevel.length)];
        return new TicketEntity(ticketLevel, ticketPrice, ticketQtd);
    }

    private LocalDate getRandomDate() {
        LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        return start.plusDays(new Random().nextInt((int) days + 1));
    }

}

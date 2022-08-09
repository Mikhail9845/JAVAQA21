import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RepositoryTest {
    Ticket ticket1 = new Ticket(1,400,"AAA", "AKC", 332);
    Ticket ticket2 = new Ticket(2,600,"AYA","MSK", 70);
    Ticket ticket3 = new Ticket(3,542,"BJN","MNP",223);
    Ticket ticket4 = new Ticket(4,675,"AAA","AGA",90);
    Ticket ticket5 = new Ticket(5,70,"KTW","UYT", 112);





    @Test

    public void add(){


        Repository repository = new Repository();
        repository.add(ticket1);

        Ticket[] excepted = {ticket1};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(excepted,actual);
    }

    @Test
    public void findById(){
        Repository repo = new Repository();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);



        Ticket excepted = ticket2;
        Ticket actual = repo.findById(2);

        Assertions.assertEquals(excepted,actual);
    }
    @Test
    public void removeTicketById(){
        Repository repo = new Repository();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        repo.removeById(3);

        Ticket[] excepted = {ticket1,ticket2,ticket4,ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(excepted,actual);

    }

    @Test
    public void removeAll(){
        Repository repo = new Repository();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);

        repo.removeAll();

        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void NotFoundException(){
        Repository repo = new Repository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }
}

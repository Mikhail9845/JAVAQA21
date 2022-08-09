import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ManagerTest {

    Repository repo = Mockito.mock(Repository.class);
    Manager manager = new Manager(repo);

    Ticket ticket1 = new Ticket(1, 400, "AAA", "AIB", 332);
    Ticket ticket2 = new Ticket(2, 700, "AAA", "AGA", 20);
    Ticket ticket3 = new Ticket(3, 542, "AHC", "AHH", 223);
    Ticket ticket4 = new Ticket(4, 675, "AAA", "AGA", 90);
    Ticket ticket5 = new Ticket(5, 414, "AAA", "AGA", 78);
    Ticket ticket6 = new Ticket(6, 213, "AAA", "AGA", 200);
    Ticket ticket7 = new Ticket(7, 223, "AAA", "AGA", 110);
    Ticket ticket8 = new Ticket(8, 545, "AKR", "ALD", 112);
    Ticket ticket9 = new Ticket(9, 400, "AAA", "AGA", 422);
    Ticket ticket10 = new Ticket(10, 400, "AAA", "AGA", 422);


    @Test

    public void findAllSort() {
        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        doReturn(tickets).when(repo).findAll();


        Ticket[] excepted = {ticket6, ticket7, ticket5, ticket4, ticket2};
        Ticket[] actual = manager.findAll("AAA", "AGA");

        Assertions.assertArrayEquals(excepted, actual);


    }


    @Test
    public void sortingEqualElements() {

        Ticket[] tickets = {ticket9, ticket10};
        doReturn(tickets).when(repo).findAll();


        Ticket[] expected = {ticket9, ticket10};
        Ticket[] actual = manager.findAll("AAA", "AGA");

        Assertions.assertArrayEquals(expected, actual);
    }



}
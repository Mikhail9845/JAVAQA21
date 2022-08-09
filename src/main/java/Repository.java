public class Repository {
    Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll(){

        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }
    public void removeAll(){
        tickets = new Ticket[0];
    }

    public Ticket[] add(Ticket ticket){
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++){
            tmp[i] = tickets[i];
        }
        tmp[tmp.length -1] = ticket;
        tickets = tmp;
        return tmp;
    }

    public Ticket[] removeById(int id){
        if (findById(id) == null) {
            throw new NotFoundException("The ticket with id: " + id + " is  not found");
        }

        Ticket[] tmp = new Ticket[tickets.length -1];
        int copyToIndex = 0;
        for(Ticket ticket: tickets){
            if(ticket.getId() != id){
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
        return tickets;
    }

}
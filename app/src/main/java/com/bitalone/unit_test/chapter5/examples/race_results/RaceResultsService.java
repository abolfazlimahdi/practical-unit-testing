package com.bitalone.unit_test.chapter5.examples.race_results;


import java.util.Collection;
import java.util.HashSet;

class RaceResultsService {

    private Collection<Client> clients = new HashSet<>();

    public void addSubscriber(Client client) {
        clients.add(client);

    }

    public void send(Message message) {
        for (Client client : clients)
            client.receive(message);
    }

    public void removeSubscriber(Client client) {
        clients.remove(client);
    }
}

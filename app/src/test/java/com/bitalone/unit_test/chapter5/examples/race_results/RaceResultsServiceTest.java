package com.bitalone.unit_test.chapter5.examples.race_results;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class RaceResultsServiceTest {

    private RaceResultsService raceResults = new RaceResultsService();
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private Message message = mock(Message.class);

    //zero subscriber
    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message);
        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    //one subscriber
    @Test
    public void subscribedClientShouldReceiveMessage() {
        raceResults.addSubscriber(clientA);
        raceResults.send(message);
        verify(clientA).receive(message);
    }

    //two subscribers
    @Test
    public void messageShouldBeSentToAllSubscribedClients() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);
        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientA);
        raceResults.send(message);
        verify(clientA).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.removeSubscriber(clientA);
        raceResults.send(message);
        verify(clientA, never()).receive(message);

    }
}

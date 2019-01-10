package com.bitalone.unit_test.chapter5.examples.messenger;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MessengerTest {

    private static final String MSG_CONTENT = "MESSAGE CONTENT";
    private static final String CLIENT_EMAIL = "test@example.com";

    @Test
    public void name() {
        Template template = mock(Template.class);
        TemplateEngine templateEngine = mock(TemplateEngine.class);
        MailServer mailServer = mock(MailServer.class);
        Client client = mock(Client.class);
        when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);
        when(client.getEmail()).thenReturn(CLIENT_EMAIL);


        Messenger sut = new Messenger(templateEngine, mailServer);
        sut.sendMessage(client, template);

        verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
    }
}
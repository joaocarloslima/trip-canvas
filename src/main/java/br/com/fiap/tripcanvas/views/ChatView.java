package br.com.fiap.tripcanvas.views;

import br.com.fiap.tripcanvas.service.TripService;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.Instant;

@Route("chat")
public class ChatView extends VerticalLayout {

    private final TripService tripService;
    private MessageInput messageInput = new MessageInput();
    private MessageList messageList = new MessageList();

    public ChatView(TripService tripService) {
        add(messageInput);
        messageInput.addSubmitListener(event -> sendMessage(event.getValue()));
        add(messageList);
        this.tripService = tripService;
    }

    private void sendMessage(String message) {
        messageList.addItem(new MessageListItem(
                message,
                Instant.now(),
                "User"
        ));

        var response = tripService.sendChatMessage(message);
        messageList.addItem(new MessageListItem(
                response,
                Instant.now(),
                "AI"
        ));
    }

}

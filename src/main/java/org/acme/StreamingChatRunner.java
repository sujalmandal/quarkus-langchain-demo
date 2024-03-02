package org.acme;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import dev.langchain4j.model.output.Response;
import org.acme.persona.Persona;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class StreamingChatRunner {

    public static final String MODEL_NAME = "dolphin-mixtral";
    public static final String BASE_URL = "http://localhost:11434";

    public static void main(String[] args) throws InterruptedException {
        // Build the ChatLanguageModel
        StreamingChatLanguageModel model = OllamaStreamingChatModel.builder().baseUrl(BASE_URL).modelName(MODEL_NAME)
                .temperature(0.7).repeatPenalty(1.5).build();

        var input = "";
        var scanner = new Scanner(System.in);
        var latch = new CountDownLatch(1);
        do {
            System.out.print("> ");
            input = scanner.nextLine();
            converse(model, input, latch);
            latch.await();
        }
        while(!input.equals("bye"));

    }

    private static void converse(StreamingChatLanguageModel model, String message, CountDownLatch latch) {
        model.generate(
                List.of(Persona.ABUSIVE.getSystemMessage(), UserMessage.from(message)),
                new StreamingResponseHandler<>() {
                    @Override
                    public void onComplete(Response<AiMessage> response) {
                        System.out.println();
                        latch.countDown();
                    }

                    @Override
                    public void onNext(String token) {
                        System.out.print(token);
                    }

                    @Override
                    public void onError(Throwable error) {
                        error.printStackTrace();
                    }
                }
        );
    }

}

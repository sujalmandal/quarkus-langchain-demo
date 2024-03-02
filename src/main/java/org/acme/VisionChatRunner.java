package org.acme;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import dev.langchain4j.model.output.Response;
import org.acme.persona.Persona;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class VisionChatRunner {

    public static final String MODEL_NAME = "llava";
    public static final String BASE_URL = "http://localhost:11434";

    public static void main(String[] args) throws InterruptedException {

    }
}

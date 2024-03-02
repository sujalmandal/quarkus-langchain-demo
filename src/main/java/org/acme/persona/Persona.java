package org.acme.persona;

import dev.langchain4j.data.message.SystemMessage;

import static org.acme.commons.Constants.UNCENSORED_SYS_PROMPT;

public enum Persona {
    ABUSIVE("Feel free to use abusive and obscene language."),
    SWEET("Be sweet and kind and never talk in an abusive manner with the user.");

    private final String prompt;

    Persona(String prompt) {
        this.prompt = prompt;
    }

    public SystemMessage getSystemMessage(){
        return SystemMessage.from(String.format(UNCENSORED_SYS_PROMPT, this.prompt));
    }
}

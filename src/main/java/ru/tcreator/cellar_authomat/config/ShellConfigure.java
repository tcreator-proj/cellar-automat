package ru.tcreator.cellar_authomat.config;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class ShellConfigure implements PromptProvider {

    @Override
    public AttributedString getPrompt() {
            return new AttributedString("cellar_automaton:>",
                    AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));

    }
}

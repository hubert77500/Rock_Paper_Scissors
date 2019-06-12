package enumeration;

import java.util.Arrays;
import java.util.Optional;

public enum PlayElement {
    ROCK(0),
    PAPER(1),
    SCISSORS(2);

    private final int value;

    PlayElement(int value) {
        this.value = value;
    }

    public static Optional<PlayElement> valueOf(int value) {
        return Arrays.stream(values())
                .filter(playElement -> playElement.value == value)
                .findFirst();
    }
}
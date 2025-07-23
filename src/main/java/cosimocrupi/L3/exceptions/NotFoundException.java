package cosimocrupi.L3.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("La fonte con id "+ id + " non è stata trovata!");
    }
}

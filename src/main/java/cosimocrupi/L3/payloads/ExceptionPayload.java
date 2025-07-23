package cosimocrupi.L3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionPayload {
    protected String message;
    protected LocalDateTime timeGet;
}

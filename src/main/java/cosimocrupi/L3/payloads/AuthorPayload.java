package cosimocrupi.L3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class AuthorPayload {
    private String name;
    private String surname;
    private String email;
    private LocalDate dataDiNascita;

    @Override
    public String toString() {
        return "AuthorPayload{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}

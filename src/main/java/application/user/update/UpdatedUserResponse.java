package application.user.update;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedUserResponse {

    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;

}

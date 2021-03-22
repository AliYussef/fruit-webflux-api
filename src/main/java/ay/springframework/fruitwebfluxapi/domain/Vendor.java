package ay.springframework.fruitwebfluxapi.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by aliyussef on 22/03/2021
 */
@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

    @Id
    private String id;
    private String firstName;
    private String lastName;
}

package org.authentication.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequences")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Sequence {
    @Id
    private String name; // Name of the sequence (e.g., "user_sequence")
    private long value; // Current value of the sequence
}

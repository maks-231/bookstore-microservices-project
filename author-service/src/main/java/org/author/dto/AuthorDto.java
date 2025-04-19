package org.author.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthorDto implements Serializable {
    private Long id;
    private String name;
    private String email;
}

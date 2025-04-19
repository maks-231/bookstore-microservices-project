package org.book.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ImageDto implements Serializable {
    private Long id;
    private String content;
}

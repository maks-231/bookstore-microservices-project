package org.genre.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GenreDto implements Serializable {
  private Long id;
  private String name;
}

package org.store.book.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PublisherDto implements Serializable {
  private Long id;
  private String name;
}

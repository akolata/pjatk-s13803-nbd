package pl.akolata.s13803.riak.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotographicFilm implements Serializable {
    private String brand;
    private String model;
    private Boolean colour;
    private Integer exposuresCount;
    private Integer iso;
    private String format;
}

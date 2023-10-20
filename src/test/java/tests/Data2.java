package tests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Data2 {


    private String id;
    private String name;

    private int  year;

    private String color;

    @JsonProperty("pantone_value")
    private String pantoneValue;

    @Override
    public String toString() {
        return "Data2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", pantoneValue='" + pantoneValue + '\'' +
                '}';
    }
}

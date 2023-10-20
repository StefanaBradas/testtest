package tests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class ResourceList {


    private String page;
    @JsonProperty("per_page")
    private String perPage;
    private String total;

    @JsonProperty("total_pages")
    private String totalPages;


    @JsonProperty("data")

    private List <Data2> listOfData2= new ArrayList<>();

    private Support support;


}

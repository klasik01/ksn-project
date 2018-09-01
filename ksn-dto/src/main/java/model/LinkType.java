package model;

import dto.LinkTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkType {

    private LinkTypeEnum action;
    private String url;
    private String description;

}

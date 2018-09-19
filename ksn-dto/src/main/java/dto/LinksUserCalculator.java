package dto;

import rs.user.User;

import java.util.ArrayList;
import java.util.List;

public class LinksUserCalculator {

    public static List<LinkType> resolved(User entity) {
        List<LinkType> links = new ArrayList<>();

        links.add(new LinkType(LinkTypeEnum.SELF, "url", "self"));

        return links;
    }
}

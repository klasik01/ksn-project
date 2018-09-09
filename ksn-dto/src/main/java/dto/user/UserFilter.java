package dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * class UserFilter
 *
 * @author Stanislav KASIKA, 8.9.2018
 * @positon Developer
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Getter
@ToString
@Slf4j
public class UserFilter {
    private String country = "";

    String REGEX_REQ_PARAM_PART_SEPARATOR = "::";
    String REGEX_REQ_PARAM_FILTER_SEPARATOR = "\\|";

    @SneakyThrows({ReflectiveOperationException.class})
    public UserFilter(String filter) {
        for (String filterElement : StringUtils.trimToEmpty(filter).split(REGEX_REQ_PARAM_FILTER_SEPARATOR)) {
            String[] filterParts = StringUtils.trimToEmpty(filterElement).split(REGEX_REQ_PARAM_PART_SEPARATOR, 2);
            try {
                if (filterParts.length == 2) {
                    UserFilter.class.getDeclaredField(filterParts[0]).set(this, StringUtils.trimToEmpty(filterParts[1]));
                }
            } catch (NoSuchFieldException e) {
                log.error("Unknown field for filtering of audit periods has been received: {}", filterParts[0], e);
            }
        }
    }
}



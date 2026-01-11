package hexlet.code.formatters;

import hexlet.code.CompareResultItem;
import hexlet.code.Formatter;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

public final class JsonFormatter implements Formatter {
    @Override
    public String format(List<CompareResultItem> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }
}

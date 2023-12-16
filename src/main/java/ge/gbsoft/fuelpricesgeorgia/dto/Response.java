package ge.gbsoft.fuelpricesgeorgia.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Response {
    private final Map<String, Object> data = new HashMap<>();
    private final Map<String, Object> error = new HashMap<>();

    public Response addData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Response addError(String key, Object value) {
        this.error.put(key, value);
        return this;
    }

}

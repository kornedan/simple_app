package simple.app.simple_app.local;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalFile {
    private String name;
    private String downloadUri;
    private String deleteUri;
}

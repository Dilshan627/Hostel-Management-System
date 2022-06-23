package bo.custom;

import bo.SuperBO;

import java.io.IOException;
import java.util.List;

public interface DetailsBO extends SuperBO {

    List<String> roomId() throws IOException;

    List<String> StudentId() throws IOException;

    List<String> search(String id) throws IOException;
}

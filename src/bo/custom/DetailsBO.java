package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;


import java.io.IOException;
import java.util.List;

public interface DetailsBO extends SuperBO {

    List<Object[]> details() throws IOException;
}

package bo.custom;

import bo.SuperBO;

import java.io.IOException;

public interface DashboardBo extends SuperBO {
    String allCount() throws IOException;

    String allRegCount() throws IOException;
}

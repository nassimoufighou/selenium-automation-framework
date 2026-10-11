package cucumber;

import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

public final class DataTableHelper {

    public static Map<String, String> getRow(DataTable table, int row) {
        List<Map<String, String>> rows = table.asMaps();
        if (rows.isEmpty()) throw new IllegalArgumentException("The DataTable has no data rows, only a header.");
        return rows.get(row);
    }

    public static String getColumn(Map<String, String> row, String column) {
        if (!row.containsKey(column)) {
            throw new IllegalArgumentException(
                    String.format("Column '%s' not found. Available columns: %s", column, row.keySet()));
        }
        return row.get(column);
    }
}
package cucumber.utils;

import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

public final class DataTableHelper {

    public static int rowCount(DataTable table) {
        return Math.max(0, table.height() - 1);
    }

    public static Map<String, String> getRow(DataTable table, int row) {
        List<Map<String, String>> rows = table.asMaps();
        if (rows.isEmpty()) throw new IllegalArgumentException("The DataTable has no data rows, only a header.");
        return rows.get(row);
    }

    public static String getColumnFromRow(DataTable table, String column, int row) {
        Map<String, String> currentRow = getRow(table, row);
        if (!currentRow.containsKey(column)) {
            throw new IllegalArgumentException(
                    String.format("Column '%s' not found. Available columns: %s", column, currentRow.keySet()));
        }
        return currentRow.get(column);
    }
}
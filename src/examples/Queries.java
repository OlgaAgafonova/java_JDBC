package examples;

public enum Queries {
    INSERT_ROW("INSERT INTO USERS (NAME, AGE, MAIL) VALUES (?,?,?)"),
    SELECT_ALL("SELECT * FROM USERS"),
    DELETE_BY_ID("DELETE FROM USERS WHERE ID = ?"),
    DELETE_BY_NAME("DELETE FROM USERS WHERE NAME = ? OR NAME IS NULL OR NAME LIKE ''"),
    DELETE_BY_AGE("DELETE FROM USERS WHERE AGE = ? OR AGE IS NULL OR AGE = 0"),
    UPDATE_NAME_BY_ID("UPDATE USERS SET NAME = ? WHERE ID = ?");

    private final String query;   // запрос

    Queries(String query) {
        this.query = query;
    }

    public final String getQuery() {
        return query;
    }
}

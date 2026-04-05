package api.routes;

public class Route {

    public static String base_path = "/api";

    // USERS
    public static String get_user = base_path + "/users/{id}";
    public static String create_user = base_path + "/users";

    // AUTH
    public static String login = base_path + "/login";
}
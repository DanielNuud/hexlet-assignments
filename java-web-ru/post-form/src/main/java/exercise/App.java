package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Collections;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        // BEGIN
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });


        app.post("/users", ctx -> {
            var firstName = ctx.formParam("firstName");
            var lastName = ctx.formParam("lastName");

            var newFirst = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
            var newLast = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

            var email = ctx.formParam("email").toLowerCase().trim();
            var password = ctx.formParam("password");
            var encryptedPass = Security.encrypt(password);

            var user = new User(newFirst, newLast, email, encryptedPass);
            UserRepository.save(user);
            ctx.redirect("/users");
        });
// END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

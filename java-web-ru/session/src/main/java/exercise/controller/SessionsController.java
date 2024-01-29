package exercise.controller;

import java.util.Collections;
import java.util.Optional;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.checkerframework.checker.units.qual.C;

public class SessionsController {

    // BEGIN
    public static void loginPage(Context ctx) {
        var page = new LoginPage("", null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void login(Context ctx) {
        var username = ctx.formParam("username");
        var password = ctx.formParam("password");
        var encryptedPass = Security.encrypt(password);
        var user = UsersRepository.findByName(username);

        if (user != null && user.getPassword().equals(encryptedPass)) {
            ctx.sessionAttribute("currentUser", username);
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            var page = new LoginPage(username, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void mainPage(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
    // END
}

package frontcontroller;

import controllers.UserController;
import io.javalin.Javalin;

public class FrontController {
	Javalin app;
	Dispatcher dispatcher;

	public FrontController(Javalin app) {
		this.app = app;

		// login for the employee/manager portal
		app.post("/logins", ctx -> {
			if (UserController.employeeLogin(ctx).equals("employee")) {
				ctx.redirect("http://localhost:9000/fcce.html");
			} else if (UserController.employeeLogin(ctx).equals("manager")) {
				ctx.redirect("http://localhost:9000/fccm.html");
			} else {
				ctx.redirect("http://localhost:9000/fcc.html");
			}
		});
		
		// log off for the employee/manager portal
		app.post("/logoff", ctx -> {
			UserController.logout(ctx);
			ctx.redirect("http://localhost:9000/fcc.html");
		});
		
		// check for invalid login
		app.get("/invalid", ctx -> {
			if (ctx.sessionAttribute("currentUser") != null) {
				ctx.sessionAttribute("currentUser", null);
				ctx.json("invalid");
			} else {
				ctx.json("reset");
			}
		});
		this.dispatcher = new Dispatcher(app);
	}
}

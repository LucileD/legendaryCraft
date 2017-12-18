package legendaryCraft;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import legendaryCraft.personnage.Joueur;
import legendaryCraft.personnage.JoueurRepository;

@Controller
@AutoConfigureDataMongo
@RequestMapping("/app")
public class LoginController {
	
	@Autowired
	private JoueurRepository repository;

	@RequestMapping("/login")
	public String loging(Principal principal,Model model) {	
		System.out.println("getLogin");
		return "login";
    }	
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	public void loginp(Principal principal,Model model,@RequestParam String username,@RequestParam String password, HttpServletResponse response) throws IOException {	
	//	if(username.equals("truc") && password.equals("muche"))

		System.out.println("postLogin");
		response.sendRedirect("/app/joueur");
    }
	
}

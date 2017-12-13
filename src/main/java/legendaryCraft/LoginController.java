package legendaryCraft;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	


	@RequestMapping("/login")
	public String loging(Principal principal,Model model) {	
		return "login";
    }	
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	public void loginp(Principal principal,Model model,@RequestBody String username,@RequestBody String password, HttpServletResponse response) throws IOException {	
		if(username.equals("truc") && password.equals("muche"))
			response.sendRedirect("/app/joueur");
    }
	
	
}

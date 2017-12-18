package legendaryCraft;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index.html")
	public String index(Model model, Principal principal) {
		if (principal == null) {
			model.addAttribute("nonConnecte", true);
		} else {
			model.addAttribute("estConnecte", true);
		}
		return "index";
	}
	
}

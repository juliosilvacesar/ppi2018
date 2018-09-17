import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class nomeDaClasse {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String nomeDaClasse = "br.com.caelum.mvc.logica." +
				request.getParameter("logica");
				Class classe = Class.forName(nomeDaClasse);
				Object objeto = classe.newInstance();
	}

}

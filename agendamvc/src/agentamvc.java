import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.daos.ContatoDAO;
import agenda.models.Contato;

public class agentamvc {

	public class SistemaTodoServlet extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String acao = request.getParameter("logica");
			ContatoDAO dao = new ContatoDAO();
			if (acao.equals("AdicionaContato")) {
				Contato contato = new Contato();
				contato.setNome(request.getParameter("nome"));
				contato.setEndereco(request.getParameter("endereco"));
				contato.setEmail(request.getParameter("email"));
				dao.inserir(contato);

				RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
				rd.forward(request, response);

				String nomeDaClasse = request.getParameter("logica");
				Logica logica = (Logica) nomeDaClasse.newInstance();
				logica.executa(request, response);
				try {
					new nomeDaClasse().executa(request, response);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (acao.equals("ListaContatos")) {
				new AdicionaContato().executa(request, response);
			} else if (acao.equals("RemoveContato")) {
				new ListaContatos().executa(request, response);
			}

		}
	}

}

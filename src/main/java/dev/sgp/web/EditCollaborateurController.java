package dev.sgp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Zahour Mehdi Classe EditerCollaborateurController
 */
public class EditCollaborateurController extends HttpServlet {

	@Override
	/**
	 * Methode doGet permettant de editer lun collaborateur, envoie un msg d'erreur si pas de matricule
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Recupere la valeur d'un parametre dont le nom est matricule
		String matriculeParam = req.getParameter("matricule");
		if (matriculeParam==null) {
			resp.setStatus(400);
			resp.getWriter().write("Un matricule est attendu");

		} else {
			resp.setStatus(200);
			resp.setContentType("text/html");
			// code HTML ecrit dans le corps de la reponse
			resp.getWriter()
					.write("<h1>Edition de collaborateur</h1>" + "<br/>" + "<p>Matricule : " + matriculeParam + "</p>");

		}

	}
	/**
	 * Methode doPost permettant de créer un collaborateurs renvoie un msg d'erreur si il y a une information qui manque
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String matriculeParam = req.getParameter("matricule");
		String titreParam = req.getParameter("titre");
		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");
		String msgError;
		
		if (matriculeParam == null || titreParam==null	|| nomParam==null || prenomParam==null ) {

			msgError = "Les parametres suivants sont incorrects : ";
			
			if (matriculeParam == null) {
				msgError+=" Matricule ";
			}
			if (titreParam == null) {
				msgError+=" titre ";
			}
			if (nomParam == null) {
				msgError+=" nom ";
			}
			if (prenomParam == null) {
				msgError+=" prenom ";
			}
			resp.setStatus(400);
			resp.getWriter().write(msgError);
		} else {
			resp.setStatus(201);
			resp.setContentType("text/html");
			resp.getWriter()
			.write("<h1>Creation d’un collaborateur avec les informations suivantes :</h1>" + "<br/>" 
					+ "<p>Matricule : " + matriculeParam + "</p>"
					+ "<p>,Titre : " + titreParam + "</p>"
					+ "<p>,Nom : " + nomParam + "</p>"
					+ "<p>,Prenom : " + prenomParam + "</p>");
		}
		
		
		
	}
	
}
package app;

import javax.servlet.annotation.WebServlet;

public class AddKysymykset {

	/*
	 * The name of the servlet is AddKysymykset
	 * and the servlet's URI (url-pattern) is 'addkysymykset'
	 */
	@WebServlet(
			name = "AddKysymykset",
			urlPatterns = {"/addkysymykset"}
			)
	public class AddKysymykset extends HttpServlet {
		/*
		 * If the request type is POST, the request is transferred to the method doGet
		 */
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws IOException, ServletException {
			doGet(request, response);
			
			
		}
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws IOException, ServletException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();

			/*
			 * With a RequestDispatcher object is the htmlstart.html file included to this servlet
			 */
			RequestDispatcher rd=request.getRequestDispatcher("htmlstart.html");
			rd.include(request,  response);;
			
			// Read parameters to Model
			 Kysymykset kysymykset =readKysymykset(request);
		
			// Create connection
			Dao dao=new Dao();
			
			// Save value and query total list
			dao.saveKysymykset(kysymykset);
			ArrayList<Kysymykset> list=dao.readAllKysymkset();
			
			// print output and close connection
			printKysymyksetList(out, list);
			dao.close();
			
			out.println("Kiitos vastauksista!");
			out.println(kysymykset);
			out.println("<br><a href='./form.html'>Back to form</a>");

			/*
			 * With a RequestDispatcher object is the htmlend.html file included to this servlet
			 */
			rd=request.getRequestDispatcher("htmlend.html");
			rd.include(request,  response);;
			
		}


		
		private Kysymykset readKysymykset(HttpServletRequest request) {
			// TODO Auto-generated method stub
			Kysymykset kysymykset=new Kysymykset();

			//ehdokas.setId(Integer.parseInt(request.getParameter("id")));
			kysymykset.setEka(request.getParameter("Suomessa on liian helppo elää sosiaaliturvan varassa."));
			kysymykset.setToka(request.getParameter("Kaupan ja muiden liikkeiden aukioloajat on vapautettava."));
			kysymykset.setKolmas(request.getParameter("Suomessa on siirryttävä perustuloon joka korvaisi nykyisen sosiaaliturvan vähimmäistason."));
			kysymykset.setNelja(request.getParameter("Tyäntekijällä on turvattava lailla minimityöaika."));
			kysymykset.setViis(request.getParameter("Ansiosidonnaisen tyättämyysturvan kestoa pitäisi lyhentää."));
			kysymykset.setKuus(request.getParameter("Euron ulkopuolella Suomi pärjäisi paremmin"));
			kysymykset.setSeiska(request.getParameter("Ruoan verotusta on varaa kiristää."));
			kysymykset.setKasi(request.getParameter("Valtion ja kuntien taloutta on tasapainotettava ensisijaisesti leikkaamalla menoja."));
			kysymykset.setYsi(request.getParameter("Lapsilisiä on korotettava ja laitettava verolle."));
			kysymykset.setKyba(request.getParameter("Suomella ei ole varaa nykyisen laajuisiin sosiaali- ja terveyspalveluihin."));
			kysymykset.setYkstoist(request.getParameter("Nato-jäsenyys vahvistaisi Suomen turvallisuuspoliittista asemaa."));
			kysymykset.setKakstoist(request.getParameter("Suomeen tarvitaan enemmän poliiseja."));
			kysymykset.setKolmetoist(request.getParameter("Maahanmuuttoa Suomeen on rajoitettava terrorismin uhan vuoksi."));
			kysymykset.setNeljatoist(request.getParameter("Venäjän etupiiripolitiikka on uhka Suomelle."));
			kysymykset.setViistoist(request.getParameter("Verkkovalvonnassa valtion turvallisuus on tärkeämpää kuin kansalaisten yksityisyyden suoja."));
			kysymykset.setKuustoist(request.getParameter("Suomen on osallistuttava Isisin vastaiseen taisteluun kouluttamalla Irakin hallituksen joukkoja."));
			kysymykset.setSeittemantoist(request.getParameter("Parantumattomasti sairaalla on oltava oikeus avustettuun kuolemaan."));
			kysymykset.setKaheksantoist(request.getParameter("Terveys- ja sosiaalipalvelut on tuotettava ensijaisesti julkisina palveluina."));
			kysymykset.setYheksantoist(request.getParameter("Viranomaisten pitää puuttua lapsiperheiden ongelmiin nykyistä herkemmin"));
			
			
			return kysymykset;
		}
		
		private void printKysymyksetList(PrintWriter out, ArrayList<Kysymykset> list) {
			out.println("<ul>");
			for (Kysymykset g:list) {
				out.println("<li>"+g);
			}
			out.println("</ul>");
		}

	}
}

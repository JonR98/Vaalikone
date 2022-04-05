<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Ehdokas" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit kysymykset</title>
</head>
<body>

	<form action='./editkysymys' method='post'>
		Suomessa on liian helppo elää sosiaaliturvan varassa <input type='text' name='eka'value='${sessionScope.kysymykset.eka }'><br>
		Kaupan ja muiden liikkeiden aukioloajat on vapautettava. <input type='text' name='toka'value='${sessionScope.kysymykset.toka }'><br>
		Suomessa on siirryttävä perustuloon joka korvaisi nykyisen sosiaaliturvan vähimmäistason. <input type='text' name='kolmas'value='${sessionScope.kysymykset.kolmas }'><br>
		Tyäntekijälle on turvattava lailla minimityäaika. <input type='text' name='nelja'value='${sessionScope.kysymykset.nelja }'><br>
		Ansiosidonnaisen tyättämyysturvan kestoa pitää lyhentää. <input type='text' name='viis' value='${sessionScope.kysymykset.viis }'><br>
		Euron ulkopuolella Suomi pärjäisi paremmin. <input type='text' name='kuus' value='${sessionScope.kysymykset.kuus }'><br>
		Ruoan verotusta on varaa kiristää. <input type='text' name='seiska' value='${sessionScope.kysymykset.seiska }'><br>
		Valtion ja kuntien taloutta on tasapainotettava ensisijaisesti leikkaamalla menoja. <input type='text' name='kasi' value='${sessionScope.kysymykset.kasi }'><br>
		Lapsilisiä on korotettava ja laitettava verolle. <input type='text' name='ysi' value='${sessionScope.kysymykset.ysi }'><br>
		Suomella ei ole varaa nykyisen laajuisiin sosiaali- ja terveyspalveluihin. <input type='text' name='kyba' value='${sessionScope.kysymykset.kyba }'><br>
		Nato-jäsenyys vahvistaisi Suomen turvallisuuspoliittista asemaa. <input type='text' name='ykstoist' value='${sessionScope.kysymykset.ykstoist }'><br>
		Suomeen tarvitaan enemmän poliiseja. <input type='text' name='kakstoist' value='${sessionScope.kysymykset.kakstoist }'><br>
		Maahanmuuttoa Suomeen on rajoitettava terrorismin uhan vuoksi.<input type='text' name='kolmetoist' value='${sessionScope.kysymykset.kolmetoist }'><br>
		Venäjän etupiiripolitiikka on uhka Suomelle.<input type='text' name='neljatoist' value='${sessionScope.kysymykset.neljatoist }'><br>
		Verkkovalvonnassa valtion turvallisuus on tärkeämpää kuin kansalaisten yksityisyyden suoja.<input type='text' name='viistoist' value='${sessionScope.kysymykset.viistoist }'><br>
		Suomen on osallistuttava Isisin vastaiseen taisteluun kouluttamalla Irakin hallituksen joukkoja. <input type='text' name='kuustoist' value='${sessionScope.kysymykset.kuustoist }'><br>
		Parantumattomasti sairaalla on oltava oikeus avustettuun kuolemaan. <input type='text' name='seittemantoist' value='${sessionScope.kysymykset.seittemantoist }'><br>
		Terveys- ja sosiaalipalvelut on tuotettava ensijaisesti julkisina palveluina.<input type='text' name='kaheksantoist' value='${sessionScope.kysymykset.kaheksantoist }'><br>
		Viranomaisten pitää puuttua lapsiperheiden ongelmiin nykyistä herkemmin. <input type='text' name='yheksantoist' value='${sessionScope.kysymykset.yheksantoist }'><br>
		
		
		
			
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>
</html>
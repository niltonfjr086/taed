package taed_portfolio.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleTeste {


	public static void main(String[] args) {
		
		System.out.println("OK");

		Date dtTeste = defineData("01/01/2000");
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(simpleDate.format(dtTeste));
		System.out.println(dtTeste);
		
		
	}

	static Date defineData(String date) {

		Date retorno = new Date();

		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			retorno = simpleDate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return retorno;
	}




}

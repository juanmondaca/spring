package cl.curso.springboot.microservicios.app.servicios;

import org.springframework.stereotype.Service;

@Service
public class ArtimeticaServiceImpl implements IArtimeticaService {

	@Override
	public Long operacionAritmetica(Long n1, Long n2, String operacion) {
		Long resultado = 0L;

		switch (operacion) {
		case "+":
			resultado = n1 + n2;
			break;
		case "-":
			resultado = n1 - n2;
			break;
		case "*":
			resultado = n1 * n2;
			break;
		case ":": // : en lugar de / por que en la uri de llamada se confunde con el / de las PathVariables
			if (n2 != 0)
				resultado = n1 / n2;
			break;
		default:
			break;
		}
		return resultado;

	}

}

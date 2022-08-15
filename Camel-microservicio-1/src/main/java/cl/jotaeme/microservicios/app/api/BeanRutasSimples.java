package cl.jotaeme.microservicios.app.api;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/api-camel-simple")
public class BeanRutasSimples {
	@Autowired
	private ProducerTemplate pt;

	@GetMapping("/rutasimple")
	public void rutaSimple() {
		pt.start();
		pt.requestBody("timer:timer-uno?period=5000", null, null);
		pt.stop();
	}

}

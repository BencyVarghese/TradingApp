package com.deutsche.bank.tradingApp.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.deutsche.bank.tradingApp.exception.ConfiguredMethodNotAvailable;
import com.deutsche.bank.tradingApp.thirdParty.Algo;

@Component
public class Application implements SignalHandler {

	Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private Algo algo;
	/**
	 * Fetch the SignalMap from Spring Boot Config server
	 */
	@Value("#{${trading-application.map.of.list}}")
	public Map<Integer, List<String>> signalList;

	/**
	 * For given signal the configured methods of Algo will called 
	 */
	@Override
	public void handleSignal(int signal) {

		List<String> list = signalList.get(signal);
		if (list == null) {
			algo.cancelTrades();
			algo.doAlgo();
			logger.info("Given signal " + signal + " not yet configured hence excuting default method");
		} else {
			for (String methodName : list) {
				if (methodName.contains("setAlgoParam")) {
					String[] param = methodName.split(",");
					algo.setAlgoParam(Integer.parseInt(param[1]), Integer.parseInt(param[2]));
				} else {
					try {
						Method method = algo.getClass().getMethod(methodName);
						method.invoke(algo);
					} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						logger.error("Error in Method Configured", e);
						throw new ConfiguredMethodNotAvailable("For given signal  " + signal + " the functionality "
								+ methodName + " not configured correctly");

					}
				}
			}
			algo.doAlgo();

		}
	}
}

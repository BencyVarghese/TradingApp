package com.deutsche.bank.tradingApp.service.logic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.deutsche.bank.tradingApp.exception.ConfiguredMethodNotAvailable;
import com.deutsche.bank.tradingApp.service.Worker;
import com.deutsche.bank.tradingApp.thirdParty.Algo;


@Service
public class TradeAppService {
	
	@Autowired
	private Algo algo;
	
	@Value("#{${trading-application.map.of.list}}")
	public Map<Integer, List<String>> signalList;

	public Worker getSignalTask(Integer signal){
		List<String> list = signalList.get(signal);
		Worker worker;
		if(list==null) {
			 worker = () -> {
			algo.cancelTrades();
			algo.doAlgo();
			};
			return worker;
		}
		worker = () -> {
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
						throw new ConfiguredMethodNotAvailable("For given signal  " + signal + " the functionality " + methodName +" not configured correctly" );
						
					}
				}
			}
			algo.doAlgo();
			
		};
		return worker;
	}

}

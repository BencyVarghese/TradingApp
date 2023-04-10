package com.deutsche.bank.tradingApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.deutsche.bank.tradingApp.exception.ConfiguredMethodNotAvailable;
import com.deutsche.bank.tradingApp.thirdParty.Algo;

public class ApplicationTest {

	@InjectMocks
	private Application application;

	@Mock
	private Algo algo;
	

	Map<Integer, List<String>> signalList;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		signalList = new HashMap<>();
		buildSignalList(1,"setUp","setAlgoParam,1,60","performCalc","submitToMarket");
		buildSignalList(2,"reverse","setAlgoParam,1,80","submitToMarket");
		buildSignalList(3,"setAlgoParam,1,90","setAlgoParam,2,15","performCalc","submitToMarket");
		buildSignalList(4,"revers");
		application.signalList = signalList;
	}
	private void buildSignalList(int signal,String... methods) {
		List<String> list = new ArrayList<>();
		for (String method : methods) {
			list.add(method);
		}
		signalList.put(signal, list);
	
	}
	@Test
	public void handleSignalnotConfiguredTest() {
		application.handleSignal(9);
		verify(algo).cancelTrades();
		verify(algo).doAlgo();
	}
	
	@Test
	public void handleSignalConfiguredTest() {
		application.handleSignal(2);
		verify(algo).reverse();
		verify(algo).setAlgoParam(1,80);
		verify(algo).submitToMarket();
		verify(algo).doAlgo();
	}
	
	@Test
	public void testHandleSignalWithConfiguredSignalAndMethodNotFound() throws Exception {

		ConfiguredMethodNotAvailable exception = assertThrows(
				ConfiguredMethodNotAvailable.class, () -> application.handleSignal(4));
		assertEquals(
				"For given signal  4 the functionality revers not configured correctly", exception.getMessage());
	}
}

package br.com.estacionamento.meiaRoda.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String[] args) {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		System.out.println(passEncoder.encode("250491"));
	}
}

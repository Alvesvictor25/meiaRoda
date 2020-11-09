package br.com.estacionamento.meiaRoda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.estacionamento.meiaRoda.model.Funcionario;
import br.com.estacionamento.meiaRoda.repository.FuncionarioRepository;

@Component
public class CustomFuncDetailService implements UserDetailsService {

	@Autowired
	private FuncionarioRepository funcRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Funcionario func = Optional.ofNullable(funcRepository.findByLogin(login))
				.orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		return new User(func.getLogin(), func.getPassword(), func.isAdmin() ? authorityListAdmin : authorityListUser);
	}

}

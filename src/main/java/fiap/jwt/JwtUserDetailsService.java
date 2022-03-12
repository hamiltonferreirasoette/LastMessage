package fiap.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fiap.configuration.Criptografia;
import fiap.owner.dto.OwnerDTO;
import fiap.owner.entity.OwnerEntity;
import fiap.owner.repository.IOwnerRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	

	@Autowired
	private IOwnerRepository iOwnerRepository;
	
//	@Autowired
//	private IMedicoRepository iMedicoRepository;
//	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		OwnerEntity user = iOwnerRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public OwnerDTO getUserByUsernameAndPassword(String username, String password) {
		OwnerEntity user = iOwnerRepository.findByUsernameAndPassword(username, Criptografia.criptografar(password));
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		OwnerDTO ownerDTO = new OwnerDTO();
		ownerDTO.setId_owner(user.getId_owner());
		ownerDTO.setUsername(user.getUsername());
		ownerDTO.setPassword(Criptografia.criptografar(user.getPassword()));
//		ownerDTO.setPacienteCode(user.getPaciente().codigo_paciente);
		return ownerDTO;
	}

//	public OwnerEntity save(OwnerDTO ownerDTO) {
////		PacienteEntity paciente = iPacienteRepository.findById(user.getPacienteCode()).orElseThrow(()-> new IllegalArgumentException("Codigo do paciente invalido"));
//		
//		OwnerEntity newUser = new OwnerEntity();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(Criptografia.criptografar(user.getPassword()));
//		newUser.setPaciente(paciente);
//		return iUsuarioRepository.save(newUser);
//	}
//	
//	public UsuarioEntity saveMedico(UserDTO user) {
//		MedicoEntity medico = iMedicoRepository.findById(user.getPacienteCode().intValue()).orElseThrow(()-> new IllegalArgumentException("Codigo do paciente invalido"));
//		
//		UsuarioEntity newUser = new UsuarioEntity();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(Criptografia.criptografar(user.getPassword()));
//		newUser.setMedico(medico);
//		
//		return iUsuarioRepository.save(newUser);
//	}

}
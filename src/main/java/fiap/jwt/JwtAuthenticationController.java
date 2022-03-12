package fiap.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fiap.owner.dto.OwnerDTO;

@RestController
@CrossOrigin
public class JwtAuthenticationController {


	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService ownerDetailsService;
	

	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		OwnerDTO id = ownerDetailsService.getUserByUsernameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword());		
		
		final UserDetails ownerDetails = ownerDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		

		final String token = jwtTokenUtil.generateToken(ownerDetails);
		

		return ResponseEntity.ok(new JwtResponse(token,id.getId_owner()));
	}
}
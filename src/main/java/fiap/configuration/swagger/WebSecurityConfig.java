package fiap.configuration.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//	@Autowired
//	private UserDetailsService jwtUserDetailsService;
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable()
//				.authorizeRequests().antMatchers(
//						"/authenticate",
//						"/api/usuario",
//						"/api/medico").permitAll().
//				anyRequest().authenticated()
//				.anyRequest().authenticated()
//			    .and().cors().and().
//				exceptionHandling().
//				authenticationEntryPoint(jwtAuthenticationEntryPoint).
//				and().csrf().disable().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//	}


	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/v2/api-docs",
	        						   "/**",
	                                   "/configuration/ui",
	                                   "/swagger-resources/**",
	                                   "/configuration/security",
	                                   "/swagger-ui.html",
	                                   "/webjars/**");
	    }
}
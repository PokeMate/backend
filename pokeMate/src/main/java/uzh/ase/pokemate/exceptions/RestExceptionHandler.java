package uzh.ase.pokemate.exceptions;

import static org.springframework.http.ResponseEntity.notFound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
	@ExceptionHandler(value = { AseException.class })
	public ResponseEntity elementNotFound(AseException ex, WebRequest request) {
		return notFound().build();
	}
}
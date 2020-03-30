package uzh.ase.pokemate.service;

import uzh.ase.pokemate.dto.UserDto;

public interface UserService {
	UserDto signup(UserDto userDto);

	UserDto updateProfile(UserDto userDto);

	UserDto changePassword(UserDto userDto, String newPassword);
}

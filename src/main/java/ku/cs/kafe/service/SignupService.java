//Titaporn Techawathanakanok 6310451081
package ku.cs.kafe.service;

import ku.cs.kafe.entity.Member;
import ku.cs.kafe.model.SignupRequest;
import ku.cs.kafe.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username){
        return repository.findByUsername(username) == null;
    }

    public void createUser(SignupRequest user){
        Member record = modelMapper.map(user, Member.class);
        record.setRole("USER");

        String hashedPasword= passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPasword);

        repository.save(record);
    }

    public Member getUser(String username){
        return repository.findByUsername(username);
    }
}

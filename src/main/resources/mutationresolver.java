@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String fullname, String email, String password, String phone) {
        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        return userRepository.save(user);
    }

    public User updateUser(Long id, String fullname, String email, String phone) {
        return userRepository.findById(id)
                             .map(user -> {
                                 if (fullname != null) user.setFullname(fullname);
                                 if (email != null) user.setEmail(email);
                                 if (phone != null) user.setPhone(phone);
                                 return userRepository.save(user);
                             })
                             .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

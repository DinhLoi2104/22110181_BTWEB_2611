@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getCategoriesByUser(Long userId) {
        return userRepository.findById(userId)
                             .map(User::getCategories)
                             .orElse(Collections.emptyList());
    }
}

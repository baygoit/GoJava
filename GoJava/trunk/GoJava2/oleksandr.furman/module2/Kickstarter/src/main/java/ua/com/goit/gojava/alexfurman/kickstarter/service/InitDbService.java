package ua.com.goit.gojava.alexfurman.kickstarter.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Transactional
@Service
public class InitDbService {

//	@Autowired
//	private RoleRepository roleRepository;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private BlogRepository blogRepository;
//
//	@Autowired
//	private ItemRepository itemRepository;
//	
//	@Autowired
//	private CategoryRepository categoryRepository;
//	
//	@Autowired
//	private ProjectRepository projectRepository;
//	
//	@Autowired
//	private QuoteRepository quoteRepository;
//	
//	@Autowired
//	private QuestionAndAnswersRepository questionAndAnswersRepository;
//	
//	@PostConstruct
//	public void init() {
//		Role roleUser = new Role();
//		roleUser.setName("ROLE_USER");
//		roleRepository.save(roleUser);
//
//		Role roleAdmin = new Role();
//		roleAdmin.setName("ROLE_ADMIN");
//		roleRepository.save(roleAdmin);
//
//		User userAdmin = new User();
//		userAdmin.setEnabled(true);
//		userAdmin.setName("admin");
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		userAdmin.setPassword(encoder.encode("admin"));
//		List<Role> roles = new ArrayList<Role>();
//		roles.add(roleAdmin);
//		roles.add(roleUser);
//		userAdmin.setRoles(roles);
//		userRepository.save(userAdmin);
//
//		Blog blogJavavids = new Blog();
//		blogJavavids.setName("JavaVids");
//		blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
//		blogJavavids.setUser(userAdmin);
//		blogRepository.save(blogJavavids);
//
//		Item item1 = new Item();
//		item1.setBlog(blogJavavids);
//		item1.setTitle("first");
//		item1.setLink("http://www.javavids.com");
//		item1.setPublishedDate(new Date());
//		itemRepository.save(item1);
//
//		Item item2 = new Item();
//		item2.setBlog(blogJavavids);
//		item2.setTitle("second");
//		item2.setLink("http://www.javavids.com");
//		item2.setPublishedDate(new Date());
//		itemRepository.save(item2);
//
//		Category category1 = new Category();
//		category1.setName("category1");
//		
//		categoryRepository.save(category1);
//		
//		Category category2 = new Category();
//		category2.setName("category2");
//		
//		categoryRepository.save(category2);
//		
//		Project project1 = new Project();
//		project1.setCategory(category1);
//		project1.setName("project1");
//		project1.setDescription("description1");
//		project1.setGoal(20000);
//		project1.setPledged(0);
//		project1.setLinksToVideo("link");
//		project1.setHistory("history1");
//		project1.setDaysLeft(26);
//		//project1.setQuestionAnswers("qa1");
//		project1.setUser(userAdmin);
//		projectRepository.save(project1);
//
//		Project project2 = new Project();
//		project2.setCategory(category1);
//		project2.setName("project2");
//		project2.setDescription("description2");
//		project2.setGoal(55525);
//		project2.setPledged(0);
//		project2.setLinksToVideo("link2");
//		project2.setHistory("history2");
//		project2.setDaysLeft(54);
//		//project2.setQuestionAnswers("qa2");
//		projectRepository.save(project2);
//		
//		Project project3 = new Project();
//		project3.setCategory(category2);
//		project3.setName("project3");
//		project3.setDescription("description3");
//		project3.setGoal(484455);
//		project3.setPledged(0);
//		project3.setLinksToVideo("link3");
//		project3.setHistory("history3");
//		project3.setDaysLeft(34);
//		//project3.setQuestionAnswers("qa3");
//		projectRepository.save(project3);
//
//		Project project4 = new Project();
//		project4.setCategory(category2);
//		project4.setName("project4");
//		project4.setDescription("description4");
//		project4.setGoal(11111);
//		project4.setPledged(0);
//		project4.setLinksToVideo("link4");
//		project4.setHistory("history4");
//		project4.setDaysLeft(54);
//		//project4.setQuestionAnswers("qa4");
//		projectRepository.save(project4);
//		
//		QuestionAndAnswers questionAndAnswers1 = new QuestionAndAnswers();
//		questionAndAnswers1.setQuestion("questionForProject1");
//		questionAndAnswers1.setAnswer("answerForProject1");
//		questionAndAnswers1.setProject(project1);
//		questionAndAnswersRepository.save(questionAndAnswers1);
//		
//		Quote quote1 = new Quote();
//		quote1.setQuote("quote1");
//		quoteRepository.save(quote1);
//		
//		Quote quote2 = new Quote();
//		quote2.setQuote("quote2");
//		quoteRepository.save(quote2);
//		
//		Quote quote3 = new Quote();
//		quote3.setQuote("quote3");
//		quoteRepository.save(quote3);
//	}
}

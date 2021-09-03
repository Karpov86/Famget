package by.karpov.famget.web;

import by.karpov.famget.dao.model.TransactionModel;
import by.karpov.famget.dao.model.UserModel;
import by.karpov.famget.dao.repo.TransactionModelRepository;
import by.karpov.famget.dao.repo.UserModelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController
{
	private static final String TRANSACTION_LIST = "transactionList";

	private final UserModelRepository userModelRepository;
	private final TransactionModelRepository transactionModelRepository;

	public HomePageController(UserModelRepository userModelRepository, TransactionModelRepository transactionModelRepository)
	{
		this.userModelRepository = userModelRepository;
		this.transactionModelRepository = transactionModelRepository;
	}

	@ModelAttribute("users")
	private List<UserModel> getUsers()
	{
		return userModelRepository.findAll();
	}

	@GetMapping("/")
	public String showHome(final Model model)
	{
		final List<TransactionModel> transactionList = new ArrayList<>();
		for (UserModel user : getUsers()) {
			transactionList.add(new TransactionModel(user));
		}
		model.addAttribute(TRANSACTION_LIST, transactionList);
		return "home";
	}

	@PostMapping("/")
	public String addAmount(@RequestParam final Long userId, @RequestParam(defaultValue = "0") BigDecimal amount)
	{
		transactionModelRepository.save(new TransactionModel(userModelRepository.findById(userId).get(), amount));
		return "home";
	}
}

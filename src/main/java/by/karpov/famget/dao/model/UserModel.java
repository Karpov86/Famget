package by.karpov.famget.dao.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "usr")
@Entity
public class UserModel extends BaseModel
{

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<TransactionModel> transactionModels;

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		UserModel userModel = (UserModel) o;
		return Objects.equals(getId(), userModel.getId());
	}

	@Override
	public int hashCode()
	{
		return 0;
	}

	@Override
	public String toString()
	{
		return getClass().getSimpleName() + "(" +
				"name = " + name + ")";
	}
}
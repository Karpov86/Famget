package by.karpov.famget.dao.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "transaction")
public class TransactionModel extends BaseModel{

	@Column(name = "amount")
	private BigDecimal amount = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserModel user;

	public TransactionModel(UserModel user)
	{
		this.user = user;
	}

	public TransactionModel(final UserModel user, final BigDecimal amount)
	{
		this.user = user;
		this.amount = amount;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		TransactionModel that = (TransactionModel) o;
		return Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode()
	{
		return 0;
	}
}

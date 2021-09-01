package by.karpov.famget.dao;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
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
	private BigDecimal amount;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;

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

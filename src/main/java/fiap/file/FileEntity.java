package fiap.file;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fiap.owner.entity.OwnerEntity;


	@Entity
	@Table(name = "MESSAGE")
	public class FileEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer codigo;

		@ManyToOne()
		@JoinColumn(referencedColumnName = "id_owner")
		private OwnerEntity owner;
}

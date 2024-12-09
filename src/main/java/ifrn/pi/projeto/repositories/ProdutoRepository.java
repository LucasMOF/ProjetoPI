package ifrn.pi.projeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.projeto.models.Loja;
import ifrn.pi.projeto.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByLoja(Loja loja);
	
	
	
}

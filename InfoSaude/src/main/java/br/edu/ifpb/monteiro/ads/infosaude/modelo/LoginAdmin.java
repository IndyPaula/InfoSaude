package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
@Entity(name = "login_admin")
@SequenceGenerator(name = "login_admin_seq", sequenceName = "login_admin_seq", initialValue = 1, allocationSize = 1)
public class LoginAdmin implements EntidadeBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "login_admin_seq")
    private Long id;
    
    @Column(name = "login_admin_name", nullable = false, length = 45, unique = true)
    private String nome;
    
    @Column(name = "login_admin_senha", nullable = false, length = 45, unique = false)
    private String senha;

    /**
     *
     * @return
     */
    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}

package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
@Entity(name = "login_admin")
@SequenceGenerator(name = "login_admin_seq", sequenceName = "login_admin_seq", initialValue = 1, allocationSize = 1)
public class LoginAdmin implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "login_admin_seq")
    private Long id;
    
    @Column(name = "login", nullable = false, length = 45, unique = true)
    private String login;
    
    @Column(name = "senha", nullable = false, length = 45, unique = false)
    private String senha;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;
    

    /**
     *
     * @return
     */
    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return login;
    }

    public void setNome(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoginAdmin other = (LoginAdmin) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}

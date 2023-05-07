package task.ninja.TaskNinja.usuarios.pessoas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import task.ninja.TaskNinja.usuarios.pessoas.dtos.CriarPessoasDto;

import java.util.Date;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoas {

    public Pessoas(CriarPessoasDto pessoasDto){
        this.setNome(pessoasDto.nome());
        this.setEmail(pessoasDto.email());
        this.setData_nascimento(pessoasDto.data_nascimento());
        this.setCpf(pessoasDto.cpf());
        this.setSexo(pessoasDto.sexo());
    }
    private String nome;

    private Date data_nascimento;
    private String cpf;
    private String email;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;


}

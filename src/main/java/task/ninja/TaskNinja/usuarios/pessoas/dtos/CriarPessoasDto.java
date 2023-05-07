package task.ninja.TaskNinja.usuarios.pessoas.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import task.ninja.TaskNinja.usuarios.pessoas.Pessoas;
import task.ninja.TaskNinja.usuarios.pessoas.Sexo;

import java.util.Date;

public record CriarPessoasDto(@NotBlank String nome, @NotBlank Date data_nascimento, @NotBlank String cpf, @NotBlank String email, @NotNull Sexo sexo){
}

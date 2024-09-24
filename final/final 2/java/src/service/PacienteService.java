package service;

public interface PacienteService {
    Paciente guardar(Paciente paciente);
    Paciente buscar(Long id);
    List<Paciente> buscarTodos();
    void eliminar(Long id);
}

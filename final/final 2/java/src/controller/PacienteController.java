package controller;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
        return new ResponseEntity<>(pacienteService.guardar(paciente), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPaciente(@PathVariable Long id) {
        return new ResponseEntity<>(pacienteService.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerTodos() {
        return new ResponseEntity<>(pacienteService.buscarTodos(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

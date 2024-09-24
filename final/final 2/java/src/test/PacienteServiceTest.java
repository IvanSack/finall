@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    public void testGuardarPaciente() {
        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");

        Paciente guardado = pacienteService.guardar(paciente);
        assertNotNull(guardado);
        assertEquals("Juan", guardado.getNombre());
    }

    @Test
    public void testBuscarPaciente() {
        Paciente paciente = pacienteService.buscar(1L);
        assertNotNull(paciente);
    }
}

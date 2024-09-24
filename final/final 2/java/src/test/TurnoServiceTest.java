@SpringBootTest
public class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;

    @Test
    public void testGuardarTurno() {
        Paciente paciente = pacienteService.buscar(1L);
        Odontologo odontologo = odontologoService.buscar(1L);

        Turno turno = new Turno();
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        turno.setFecha(LocalDateTime.now());

        Turno guardado = turnoService.guardar(turno);
        assertNotNull(guardado);
    }

    @Test
    public void testBuscarTurno() {
        Turno turno = turnoService.buscar(1L);
        assertNotNull(turno);
    }

    @Test
    public void testEliminarTurno() {
        turnoService.eliminar(1L);
        assertThrows(NotFoundException.class, () -> turnoService.buscar(1L));
    }
}
{
}

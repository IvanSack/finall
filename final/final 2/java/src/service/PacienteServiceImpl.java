package service;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    private static final Logger logger = LoggerFactory.getLogger(PacienteServiceImpl.class);

    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("Guardando paciente: " + paciente.getNombre());
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscar(Long id) {
        logger.info("Buscando paciente con ID: " + id);
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Paciente no encontrado"));
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        Paciente paciente = buscar(id);
        if (paciente != null) {
            pacienteRepository.deleteById(id);
        } else {
            throw new NotFoundException("Paciente no encontrado para eliminar");
        }
    }
}

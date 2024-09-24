package service;

private static final Logger logger = LoggerFactory.getLogger(PacienteServiceImpl.class);

@Override
public Paciente guardar(Paciente paciente) {
    logger.info("Guardando paciente: " + paciente.getNombre());
    return

@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    public void testGuardarOdontologo() {
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Ana");
        odontologo.setApellido("Gomez");
        odontologo.setMatricula("A123");

        Odontologo guardado = odontologoService.guardar(odontologo);
        assertNotNull(guardado);
        assertEquals("Ana", guardado.getNombre());
    }

    @Test
    public void testBuscarOdontologo() {
        Odontologo odontologo = odontologoService.buscar(1L);
        assertNotNull(odontologo);
    }

    @Test
    public void testEliminarOdontologo() {
        odontologoService.eliminar(1L);
        assertThrows(NotFoundException.class, () -> odontologoService.buscar(1L));
    }
}

package tfg.warhammerScanner.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tfg.warhammerScanner.Repository.MiniaturaRepository;

@Component
public class DatabaseTest implements CommandLineRunner{

    private final MiniaturaRepository miniaturaRepository;

    public DatabaseTest(MiniaturaRepository miniaturaRepository) {
        this.miniaturaRepository = miniaturaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            long count = miniaturaRepository.count();
            System.out.println("Conexión a la base de datos exitosa. Miniaturas en la tabla: " + count);
        } catch (Exception e) {
            System.err.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}

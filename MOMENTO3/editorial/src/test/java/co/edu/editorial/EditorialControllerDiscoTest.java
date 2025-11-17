
package co.edu.editorial;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.edu.editorial.modelo.Disco;
import co.edu.editorial.service.IDiscoService;

public class EditorialControllerDiscoTest {

    @Mock
    private IDiscoService discoServiceMock;

    @InjectMocks
    private EditorialController editorialController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCrearDisco() {
        Disco disco = new Disco("titulo", 0, 0);

        when(discoServiceMock.crearDisco(any(Disco.class))).thenReturn(disco);

        ResponseEntity<Disco> response = editorialController.crearDisco(disco);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(disco, response.getBody());
    }

    @Test
    public void testObtenerDiscos() {
        List<Disco> discos = new ArrayList<>();
        when(discoServiceMock.getTodosLosDiscos()).thenReturn(discos);

        ResponseEntity<List<Disco>> response = editorialController.obtenerDiscos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(discos, response.getBody());
    }


    @Test
    public void testObtenerDiscoPorId() {
        ObjectId id = new ObjectId("66292c1e764cc864209e7937");
        Disco disco = new Disco("titulo", 0, 0);
        when(discoServiceMock.getDiscoPorId(id)).thenReturn(disco);

        ResponseEntity<Disco> response = editorialController.obtenerDiscoPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(disco, response.getBody());
    }


    @Test
    public void testEliminarDisco() {
        ObjectId id = new ObjectId("66292c1e764cc864209e7937");

        HttpStatus expectedStatus = HttpStatus.OK;

        HttpStatus actualStatus = editorialController.eliminarDisco(id);

        assertEquals(expectedStatus, actualStatus);
        verify(discoServiceMock).eliminarDisco(id);
    }


    @Test
    public void testActualizarDisco() {
        ObjectId id = new ObjectId("66292c1e764cc864209e7937");
        Disco disco = new Disco("titulo", 0, 0);
        disco.setId(id);

        when(discoServiceMock.actualizarDisco(disco)).thenReturn(disco);

        ResponseEntity<Disco> response = editorialController.actualizarDisco(id, disco);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(disco, response.getBody());
    }
}

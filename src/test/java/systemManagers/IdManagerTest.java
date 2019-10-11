package systemManagers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdManagerTest {

    @Test
    void generateUniqueID() {
        String idSerial = "KRIS";
        String Id = IdManager.generateUniqueID(idSerial, "offer");
        int expectedIdNum = IdManager.getIdCount("offer");
        assertEquals(Id, idSerial + expectedIdNum);
    }
}
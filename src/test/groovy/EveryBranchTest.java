import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EveryBranchTest {

    @Test
    void EveryBranchTestFunction() {
        var user = new User("Filip", "P@ssw0rd123", "filipmazev@gmail.com");

        assertTrue(SILab2.function(user, new ArrayList<User>()));
        assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<User>()));
        assertFalse(SILab2.function(new User(null, "password", "filipmazevgmailcom"), new ArrayList<User>()));
        assertFalse(SILab2.function(new User("filip", "filip", "filipmazev@gmail.com"), new ArrayList<User>()));

        var ArrayUsers = new ArrayList<User>(); ArrayUsers.add(user);
        assertFalse(SILab2.function(user, ArrayUsers));
    }

    @Test
    void MultipleConditions() {
        assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<User>()));
        assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, null, null), new ArrayList<User>()));
        assertFalse(SILab2.function(new User("filip", "p@ssw0r", "filipmazev@gmail.com"), new ArrayList<User>()));
        assertTrue(SILab2.function(new User("filip_mazev", "P@ssw0rd123", "filipmazev@gmail.com"), new ArrayList<User>()));
    }
}
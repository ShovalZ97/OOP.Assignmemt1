package observer;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class GroupAdminTest {
    final String nullstring = null;
    final String emptystring = "";
    final String newline = "\n";

    @Test
    void register() {
        GroupAdmin gpAdmin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("Shoval");
        ConcreteMember member2 = new ConcreteMember("Yam");
        ConcreteMember member3 = new ConcreteMember("Noa");
        ConcreteMember member4 = new ConcreteMember("Or");

        gpAdmin.register(member1);
        gpAdmin.register(member2);
        gpAdmin.register(member3);
        gpAdmin.register(member4);
        gpAdmin.append("123");
        assertEquals("Shoval 123 Yam 123 Noa 123 Or 123 ", gpAdmin.toStringData());
    }

    @Test
    void unregister() {
        GroupAdmin gpAdmin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("Shoval");
        ConcreteMember member2 = new ConcreteMember("Yam");
        ConcreteMember member3 = new ConcreteMember("Noa");
        ConcreteMember member4 = new ConcreteMember("Or");

        gpAdmin.register(member1);
        gpAdmin.register(member2);
        gpAdmin.register(member3);
        gpAdmin.register(member4);
        gpAdmin.append("123");
        assertEquals("Shoval 123 Yam 123 Noa 123 Or 123 ", gpAdmin.toStringData());

        gpAdmin.unregister(member1);
        gpAdmin.unregister(member2);
        gpAdmin.unregister(member3);

        assertEquals("Or 123 ", gpAdmin.toStringData());
    }

    @Test
    void insert() {
        GroupAdmin gpAdmin = new GroupAdmin();
        ConcreteMember member1=new ConcreteMember("Shoval");
        gpAdmin.register(member1);
        gpAdmin.insert(0,"Rotem");
        assertEquals("Shoval Rotem ", gpAdmin.toStringData());
        gpAdmin.insert(5,"And");
        assertEquals("Shoval RotemAnd ",gpAdmin.toStringData());
    }
    @Test
    void append() {
        GroupAdmin gpAdmin = new GroupAdmin();
        ConcreteMember member1=new ConcreteMember("Shoval");
        gpAdmin.append("Shoval");
        gpAdmin.register(member1);
        assertEquals("Shoval Shoval ", gpAdmin.toStringData());
        gpAdmin.append("Zohar");
        assertEquals("Shoval ShovalZohar ",gpAdmin.toStringData());
        gpAdmin.append("Ziv");
        assertEquals("Shoval ShovalZoharZiv ", gpAdmin.toStringData());
    }

    @Test
    void delete() {
        GroupAdmin gpAdmin = new GroupAdmin();
        ConcreteMember member1=new ConcreteMember("Shoval");
        gpAdmin.append("123");
        gpAdmin.register(member1);
        gpAdmin.delete(0,1);
        assertEquals("Shoval 23 ",gpAdmin.toStringData());
        gpAdmin.delete(0,1);
        assertEquals("Shoval 3 ", gpAdmin.toStringData());

    }

    @Test
    void undo() {
        GroupAdmin gpAdmin = new GroupAdmin();
        ConcreteMember member1=new ConcreteMember("Shoval");
        gpAdmin.append("123");
        gpAdmin.register(member1);
        gpAdmin.append("456");
        gpAdmin.insert(5,"And");
        gpAdmin.undo();
        assertEquals("Shoval 123456 ", gpAdmin.toStringData());
        gpAdmin.undo();
        assertEquals("Shoval 123 ",gpAdmin.toStringData());

    }
}

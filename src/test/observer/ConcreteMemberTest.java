package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {
        GroupAdmin gpAdmin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("Shoval");

        //****************************************
        gpAdmin.append("Shoval");
        //****************************************


        gpAdmin.register(member1);
        gpAdmin.insert(0,"LA");
        assertEquals("LAShoval", member1.getData().toString());
        gpAdmin.undo();
        assertEquals("Shoval", member1.getData().toString());
        gpAdmin.append("Ziv");
        assertEquals("ShovalZiv",member1.getData().toString());
        gpAdmin.delete(0,2);
        assertEquals("ovalZiv", member1.getData().toString());
        gpAdmin.append("A");
        assertEquals("ovalZivA", member1.getData().toString());
        gpAdmin.unregister(member1);
    }

}